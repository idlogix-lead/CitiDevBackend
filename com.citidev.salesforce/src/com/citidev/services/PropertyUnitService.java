package com.citidev.services;


import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProduct;
import org.compiere.model.MProductPrice;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citidev.client.impl.PropertyUnitApi;
import com.citidev.dto.PropertyUnitDTO;

public class PropertyUnitService {
	
	private static final Logger log = LoggerFactory.getLogger(PropertyUnitService.class);

//    private static final Object Net_Total_Price__c = null;
	private final PropertyUnitApi pUnitApi;
    

    public PropertyUnitService() {
    	this.pUnitApi = new PropertyUnitApi();
    	
    }

    public List<PropertyUnitDTO> getAllPropertyUnits() {
        return pUnitApi.getAllPropertyUnits(); 
    }
    
    public PropertyUnitDTO getPropertyUnitById(String id) {
        return pUnitApi.getPropertyUnitById(id); 
    }
    
    public void updatePropertyUnit(String id, PropertyUnitDTO dto) {
    	pUnitApi.updatePropertyUnit(id, dto.getUploadPayload());

    }
    
    public void createPropertyUnit(PropertyUnitDTO dto) {
    	pUnitApi.createPropertyUnit(dto.getUploadPayload());

    }
    
    
    private Map<String, MProduct> fetchExistingProducts(List<String> ids) {
        Map<String, MProduct> data = new HashMap<>();
        if (ids.isEmpty())
            return data;

        String placeholders = ids.stream().map(i -> "?").collect(Collectors.joining(","));
        String where = "SF_UID IN (" + placeholders + ")";
        List<MProduct> products = new Query(Env.getCtx(), MProduct.Table_Name, where, null)
                .setParameters(ids.toArray())
                .list();

        for (MProduct product : products) {
            String sfId = (String) product.get_Value("SF_UID");
            if (sfId != null)
                data.put(sfId, product);
        }
        return data;
    }
    
    public int syncUnitsFromSalesforce() {
        List<PropertyUnitDTO> units = getAllPropertyUnits();       
        Map<String, MProduct> existing = fetchExistingProducts(
                units.stream().map(PropertyUnitDTO::getId).collect(Collectors.toList()));

        for (PropertyUnitDTO dto : units) {
            MProduct product = existing.get(dto.getId());
            if (product == null) 
                product = new MProduct(Env.getCtx(), 0, null);
            populateProduct(product, dto);
            product.saveEx();
            
            createOrUpdateProductPrice(product, dto);
        }

        return units.size();
    }
    public int syncUnitsByIdFromSalesforce(String unitId) {
    	// Fetch a single unit from Salesforce
        PropertyUnitDTO unit = getPropertyUnitById(unitId);

        if (unit == null) {
            System.out.println("No unit found for ID: " + unitId);
            return 0;
        }

        // Fetch the existing product by this unit's ID
        Map<String, MProduct> existing = fetchExistingProducts(Collections.singletonList(unit.getId()));
        MProduct product = existing.get(unit.getId());

        if (product == null) {
            product = new MProduct(Env.getCtx(), 0, null);
        }

        // Populate and save the product
        populateProduct(product, unit);
        product.saveEx();
        return product.get_ID();
    }
    
    public void populateProduct(MProduct product, PropertyUnitDTO dto) {
        product.set_ValueOfColumn("SF_UID", dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getUnitType()); 
        product.setM_Product_Category_ID(105);
        product.setC_TaxCategory_ID(107);
        product.setC_UOM_ID(100);
    }
    
    private void createOrUpdateProductPrice(MProduct product, PropertyUnitDTO dto) {
    	
    	MPriceListVersion plv = new Query(Env.getCtx(), MPriceListVersion.Table_Name, "Name=?", null)
    			.setParameters("Standard 2003")
    			.first();
    	if(plv == null) {
    		log.error("Price List for Standard 2003 not found");
    	}
    	
    	MProductPrice price = new Query(Env.getCtx(), MProductPrice.Table_Name, "M_Product_Id=?", null)
    			.setParameters(product.getM_Product_ID())
    			.first();
    	
    	if(price == null) 
    		price = new MProductPrice(Env.getCtx(), 0, null);
    		
    	
    	price.setM_PriceList_Version_ID(plv.getM_PriceList_Version_ID());
    	price.setM_Product_ID(product.getM_Product_ID());
    	try {
    		if(dto.getUnitPrice() != null) {
    			BigDecimal newPrice = new BigDecimal(dto.getUnitPrice());
    			
    			price.setPriceStd(newPrice);
				price.saveEx();
				log.info("Price updated for product" + dto.getName() + "to" + newPrice);
    			
    		}
    		else {
    			MPriceList pl = new Query(Env.getCtx(), MPriceList.Table_Name, "IsDefault='Y' AND IsActive='Y'", null)
    					.setOrderBy("Created DESC")
    					.first();
    			if(pl == null) {
    				log.error("The price list is not found");
    				return;
    			}
    			MPriceListVersion latestVersion = new Query(Env.getCtx(), MPriceListVersion.Table_Name, "M_PriceList_ID=?", null)
    					.setParameters(pl.getM_PriceList_ID())
    					.first();
    			if(latestVersion == null) {
    				log.error("Latest Version is not present");
    				return;
    			}
    			price.setM_PriceList_Version_ID(latestVersion.getM_PriceList_Version_ID());
    			price.setPriceStd(BigDecimal.ZERO);
    			price.saveEx();
    		}
    		
    	}catch(Exception e){
    		log.error("Failed to save price for product:" + dto.getName(), e);
    	}
    	
    	
    }
    
}


