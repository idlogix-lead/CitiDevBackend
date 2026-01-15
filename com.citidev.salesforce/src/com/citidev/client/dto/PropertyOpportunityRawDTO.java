package com.citidev.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyOpportunityRawDTO {
	public static final String COLUMNNAME_Id = "Id";
	public static final String COLUMNNAME_Name = "Name";
	public static final String COLUMNNAME_StageName = "StageName";
	public static final String COLUMNNAME_Sales_Offer_Response__c = "Sales_Offer_Response";
	public static final String COLUMNNAME_Opportunity_Unique_Identifier__c = "Opportunity_Unique_Identifier";
	
	 @JsonProperty(COLUMNNAME_Id)
	 private String id;

	 @JsonProperty(COLUMNNAME_Name)
	 private String name;

	 @JsonProperty(COLUMNNAME_StageName)
	 private String StageName;
	    
	 @JsonProperty(COLUMNNAME_Sales_Offer_Response__c)
	 private String Sales_Offer_Response;
	    
	 @JsonProperty(COLUMNNAME_Opportunity_Unique_Identifier__c)
	 private String Opportunity_Unique_Identifier;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStageName() {
		return StageName;
	}

	public void setStageName(String stageName) {
		StageName = stageName;
	}

	public String getSales_Offer_Response() {
		return Sales_Offer_Response;
	}

	public void setSales_Offer_Response(String sales_Offer_Response) {
		Sales_Offer_Response = sales_Offer_Response;
	}

	public String getOpportunity_Unique_Identifier__c() {
		return Opportunity_Unique_Identifier;
	}

	public void setOpportunity_Unique_Identifier__c(String opportunity_Unique_Identifier__c) {
		Opportunity_Unique_Identifier = opportunity_Unique_Identifier__c;
	}

	 
}
