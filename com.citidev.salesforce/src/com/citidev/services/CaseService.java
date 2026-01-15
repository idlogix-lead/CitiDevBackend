package com.citidev.services;

import java.util.*;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MRequest;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citidev.client.impl.CaseApi;
import com.citidev.dto.CaseDTO;

public class CaseService {

    private static final Logger log = LoggerFactory.getLogger(CaseService.class);
    private final CaseApi caseApi;

    public CaseService() {
        this.caseApi = new CaseApi();
    }

    public List<CaseDTO> getAllCases() {
        return caseApi.getAllCases();
    }

    public CaseDTO getCaseById(String id) {
        return caseApi.getCaseById(id);
    }

    public CaseDTO createCase(CaseDTO dto) {
        return caseApi.createCase(dto);
    }

    public void updateCase(String id, CaseDTO dto) {
        caseApi.updateCase(id, dto);
    }

    public boolean deleteCase(String id) {
        return caseApi.deleteCase(id);
    }

    public int syncCasesFromSalesforce() {
        List<CaseDTO> dtos = getAllCases();
        if (dtos == null || dtos.isEmpty()) {
            log.warn("No cases found in Salesforce.");
            return 0;
        }

        log.info("Starting Salesforce to ERP Case sync...");
        
        Map<String, MRequest> existing = fetchExistingCases(
                dtos.stream().map(CaseDTO::getId).collect(Collectors.toList())
        );

        int syncedCount = 0;
        for (CaseDTO dto : dtos) {
            MRequest request = existing.get(dto.getId());
            if (request == null) {
                request = new MRequest(Env.getCtx(), 0, null);
            } else if (!request.isActive()) {
                log.warn("Inactive ERP request found for SF Id", dto.getId());
                continue;
            }
            populateCase(request, dto);

            try {
                request.saveEx();
                syncedCount++;
            } catch (Exception e) {
                log.error("Failed to save case for: " + dto.getCaseNumber() + " | " + e.getMessage(), e);
            }
        }

        log.info("Cases synchronized successfully:", syncedCount);
        return syncedCount;
    }

    public int syncCasesToSalesforce() {
        List<MRequest> requests = new Query(Env.getCtx(), MRequest.Table_Name, "SF_UID IS NULL AND IsActive='Y'", null)
                .list();

        if (requests == null || requests.isEmpty()) {
            log.info("No new requests found to sync to Salesforce.");
            return 0;
        }

        int syncedCount = 0;

        for (MRequest request : requests) {
            try {
                CaseDTO dto = toCaseDTO(request);
                CaseDTO response = caseApi.createCase(dto);

                if (response != null && response.getId() != null) {
                    request.set_ValueOfColumn("SF_UID", response.getId());
                    request.saveEx();
                    syncedCount++;
                    log.info("Synced Request [{}] with SF_UID: {}", request.getDocumentNo(), response.getId());
                }

            } catch (Exception e) {
                log.error("Failed to sync request: " + request.getDocumentNo() + " | " + e.getMessage(), e);
            }
        }

        log.info("Requests synced to Salesforce: {}", syncedCount);
        return syncedCount;
    }

    private CaseDTO toCaseDTO(MRequest request) {
        CaseDTO dto = new CaseDTO();
        dto.setCaseNumber(request.getDocumentNo());
        dto.setSubject(request.getSummary());
        dto.setStatus(request.getStatus() != null ? request.getStatus().getName() : null);
        dto.setPriority(request.getPriority());
        return dto;
    }

    private Map<String, MRequest> fetchExistingCases(List<String> sfIds) {
        Map<String, MRequest> data = new HashMap<>();
        if (sfIds == null || sfIds.isEmpty()) return data;

        String placeholders = sfIds.stream().map(i -> "?").collect(Collectors.joining(","));
        String where = "SF_UID IN (" + placeholders + ")";
        List<MRequest> objects = new Query(Env.getCtx(), MRequest.Table_Name, where, null)
                .setParameters(sfIds.toArray())
                .list();

        for (MRequest p : objects) {
            data.put((String) p.get_Value("SF_UID"), p);
        }
        return data;
    }

    private void populateCase(MRequest request, CaseDTO dto) {
        request.setAD_Org_ID(Env.getAD_Org_ID(Env.getCtx()));
        request.set_ValueOfColumn("SF_UID", dto.getId());

        String documentNo = dto.getCaseNumber();
        if (documentNo == null || documentNo.trim().isEmpty()) {
            documentNo = "SFCASE-" + dto.getId().substring(0, Math.min(8, dto.getId().length()));
        }
        request.setDocumentNo(documentNo);

        int requestTypeId = new Query(Env.getCtx(), "R_RequestType", "IsActive='Y'", null)
                .setOrderBy("Created ASC")
                .firstId();
        if (requestTypeId < 0)
            throw new AdempiereException("No valid Request Type found for Case sync!");
        request.setR_RequestType_ID(requestTypeId);

        String summary = dto.getSubject();
        if (summary == null || summary.trim().isEmpty())
            summary = "Salesforce Case: " + dto.getCaseNumber();
        request.setSummary(summary);

        int salesRepId = Env.getAD_User_ID(Env.getCtx());
        if (salesRepId <= 0)
            salesRepId = 101;
        request.setSalesRep_ID(salesRepId);
        
        if(dto.getPriority() != null) {
        	String priority = dto.getPriority().trim().toLowerCase();
        	if(priority.equals("high")) {
        		request.setPriority("3");
        	}
        	 else if (priority.equals("medium")) {
        	        request.setPriority("5");
        	    } 
        	    else if (priority.equals("low")) {
        	        request.setPriority("9");
        	    } 
        	    else {
        	        request.setPriority("5"); 
        	    }
        }
        else {
            request.setPriority("5"); 
        }

        
        request.setConfidentialType(MRequest.CONFIDENTIALTYPE_Internal);
    }
}
