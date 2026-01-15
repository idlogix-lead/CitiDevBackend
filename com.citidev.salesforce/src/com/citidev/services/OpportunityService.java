package com.citidev.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.compiere.model.MBPartner;
import org.compiere.model.MProduct;
import org.compiere.model.Query;
import org.compiere.util.Env;

import com.citidev.client.impl.OpportunityApi;
import com.citidev.dto.OpportunityDTO;
import com.citidev.models.MSalesForm;



public class OpportunityService {
	
	private final OpportunityApi opportunityApi;
	private final AccountService accountService;

    public OpportunityService() {
    	this.opportunityApi = new OpportunityApi();
    	this.accountService = new AccountService();
    }

    public List<OpportunityDTO> getAllOpportunities() {
        return opportunityApi.getAllOpportunities() ;
    }
    
    public OpportunityDTO getOpportunityById(String id) {
        return opportunityApi.getOpportunityById(id);
    }
    
    public int syncOpportunitiesFromSalesforce() {
        int processedCount = 0;
        List<OpportunityDTO> dtos = getAllOpportunities();

        if (dtos.isEmpty()) return 0;

        List<String> opportunityIds = dtos.stream().map(OpportunityDTO::getId).collect(Collectors.toList());
        List<String> accountIds = dtos.stream().map(OpportunityDTO::getAccount).collect(Collectors.toList());
        List<String> tower_units = dtos.stream().map(OpportunityDTO::getTower_unit_c).collect(Collectors.toList());

        Map<String, MSalesForm> existingOpportunities = fetchExistingOpportunities(opportunityIds);
        Map<String, Integer> existingPartner = fetchExistingPartnerIds(accountIds);
        Map<String, Integer> existingProduct = fetchExistingProductIds(tower_units);

//        loop through all installments:
        for (OpportunityDTO dto : dtos) {
            Integer bpartnerId = existingPartner.get(dto.getAccount());
            if (bpartnerId == null) {
            	bpartnerId = accountService.syncAccountsByIdFromSalesforce(dto.getAccount());
                if (bpartnerId != null && bpartnerId > 0) {
                    existingPartner.put(dto.getAccount(), bpartnerId);
                }
            }
            Integer productId = existingProduct.get(dto.getTower_unit_c());
            if (productId == null) {
            	continue;
            }

            MSalesForm opportunity = existingOpportunities.get(dto.getId());   
            if(opportunity == null)
            	opportunity = new MSalesForm(Env.getCtx(), 0, null);
            
            opportunity.setC_BPartner_ID(bpartnerId);
            opportunity.setName(dto.getName());
            opportunity.set_ValueOfColumn("sf_uid",dto.getId());
            opportunity.set_ValueOfColumn("m_product_id",productId);
            opportunity.saveEx();
            
            processedCount++;
        }

        return processedCount;
    }
	 private Map<String, MSalesForm> fetchExistingOpportunities(List<String> ids) { 
	        Map<String, MSalesForm> data = new HashMap<>();
	        if (ids.isEmpty())
	            return data;
	
	        String placeholders = ids.stream().map(i -> "?").collect(Collectors.joining(","));
	        String where = "SF_UID IN (" + placeholders + ") AND DocStatus != 'CO'";
	        List<MSalesForm> objects = new Query(Env.getCtx(), MSalesForm.Table_Name, where, null)
	                .setParameters(ids.toArray()) 
	                		.list();
	        objects.stream()
	        .forEach(obj -> data.put((String) obj.get_Value("SF_UID"), obj));
	        return data;
	    }
	 private Map<String, Integer> fetchExistingPartnerIds(List<String> ids) {
		    Map<String, Integer> map = new HashMap<>();
		    if (ids.isEmpty())
		        return map;

		    String placeholders = ids.stream().map(i -> "?").collect(Collectors.joining(","));
		    String where = "sf_uid IN (" + placeholders + ")";

		    List<MBPartner> partners = new Query(Env.getCtx(), MBPartner.Table_Name, where, null)
		            .setParameters(ids.toArray())
		            .list();

		    partners.stream()
		        .forEach(p -> map.put((String) p.get_Value("sf_uid"), p.getC_BPartner_ID()));

		    return map;
		}
	 private Map<String, Integer> fetchExistingProductIds(List<String> ids) {
		    Map<String, Integer> map = new HashMap<>();
		    if (ids.isEmpty())
		        return map;

		    String placeholders = ids.stream().map(i -> "?").collect(Collectors.joining(","));
		    String where = "sf_uid IN (" + placeholders + ")";

		    List<MProduct> products = new Query(Env.getCtx(), MProduct.Table_Name, where, null)
		            .setParameters(ids.toArray())
		            .list();

		    products.stream()
		        .forEach(p -> map.put((String) p.get_Value("sf_uid"), p.getM_Product_ID()));

		    return map;
		}

}
