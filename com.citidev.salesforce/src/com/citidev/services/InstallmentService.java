package com.citidev.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.compiere.model.MBPartner;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MInvoicePaySchedule;
import org.compiere.model.MProduct;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;
import com.citidev.client.impl.InstallmentApi;

import com.citidev.dto.InstallmentDTO;

public class InstallmentService {
	
	private final InstallmentApi installmentApi;
	private final AccountService accountService;
	private final PropertyUnitService propertyUnitService;

    public InstallmentService() {
    	this.installmentApi = new InstallmentApi();
    	this.accountService = new AccountService();
    	this.propertyUnitService = new PropertyUnitService();
    }

    public List<InstallmentDTO> getAllInstallments() {
        return installmentApi.getAllInstallments() ;
    }
    
    public InstallmentDTO getInstallmentId(String id) {
        return installmentApi.getInstallmentById(id);
    }
    
    public int syncInstallmentsFromSalesforce() {
        int processedCount = 0;
        List<InstallmentDTO> dtos = getAllInstallments();

        if (dtos.isEmpty()) return 0;
        
        List<String> installmentIds = dtos.stream().map(InstallmentDTO::getId).collect(Collectors.toList());
        List<String> accountIds = dtos.stream().map(InstallmentDTO::getAccount).collect(Collectors.toList());
        List<String> unitIds = dtos.stream().map(InstallmentDTO::getUnit).collect(Collectors.toList());
        
        Map<String, MInvoice> existingInvoices = fetchExistingInvoices(installmentIds);
        Map<String, Integer> existingPartner = fetchExistingPartnerIds(accountIds);
        Map<String, Integer> existingProduct = fetchExistingProductIds(unitIds);
        for (InstallmentDTO dto : dtos) {
            Integer bpartnerId = existingPartner.get(dto.getAccount());
            if (bpartnerId == null) {
            	bpartnerId = accountService.syncAccountsByIdFromSalesforce(dto.getAccount());
                if (bpartnerId != null && bpartnerId > 0) {
                    existingPartner.put(dto.getAccount(), bpartnerId);
                }
            }
            Integer productId = existingProduct.get(dto.getUnit());
            if (productId == null) {
                productId = propertyUnitService.syncUnitsByIdFromSalesforce(dto.getUnit());
                if (productId != null) {
                	existingProduct.put(dto.getUnit(), productId);
                }
            }

            BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(dto.getUnallocated_amount()));
            Timestamp invoiceDate = Timestamp.valueOf(dto.getInstallmentdate() + " 00:00:00");

            MInvoice invoice = existingInvoices.get(dto.getId());
            if(invoice == null)
            	invoice = new MInvoice(Env.getCtx(), 0, null);
            
            invoice.setC_BPartner_ID(bpartnerId);
            invoice.setDateInvoiced(invoiceDate);
            invoice.setDateAcct(invoiceDate);
            invoice.set_ValueOfColumn("sf_uid", dto.getId());
            invoice.set_ValueOfColumn("opportunityid", dto.getOpportunity());
            invoice.saveEx(); 
            MInvoiceLine line = new Query(Env.getCtx(), MInvoiceLine.Table_Name, "C_Invoice_ID=?", null)
                    .setParameters(invoice.getC_Invoice_ID())
                    .first();
            if (line == null) {
                line = new MInvoiceLine(invoice);
                line.setM_Product_ID(productId);
            } else {
                line.setM_Product_ID(productId);
            }

            line.setQty(BigDecimal.ONE);
            line.setPrice(amount);
            line.setLineNetAmt(amount);
            line.saveEx();            
            processedCount++;
        }

        return processedCount;
    }

	 private Map<String, MInvoice> fetchExistingInvoices(List<String> ids) {
	    	
	        Map<String, MInvoice> data = new HashMap<>();
	        if (ids.isEmpty())
	            return data;
	
	        String placeholders = ids.stream().map(i -> "?").collect(Collectors.joining(","));
	        String where = "SF_UID IN (" + placeholders + ") AND DocStatus != 'CO'";
	        List<MInvoice> objects = new Query(Env.getCtx(), MInvoice.Table_Name, where, null)
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
