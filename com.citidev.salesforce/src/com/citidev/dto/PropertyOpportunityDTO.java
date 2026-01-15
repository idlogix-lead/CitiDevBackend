package com.citidev.dto;

public class PropertyOpportunityDTO {
	private String id;
    private String name;
    private String StageName;
    private String Sales_Offer_Response;
    private String Opportunity_Unique_Identifier;
    private String lastModifiedDate;
    
    public PropertyOpportunityDTO() {}
    
    public PropertyOpportunityDTO(String id, String name, String StageName, String Sales_Offer_Response, String Opportunity_Unique_Identifier, String lastModifiedDate) {
    	super();
		this.id = id;
		this.name = name;
		this.StageName = StageName;
		this.Sales_Offer_Response = Sales_Offer_Response;
		this.Opportunity_Unique_Identifier = Opportunity_Unique_Identifier;
		 this.lastModifiedDate = lastModifiedDate;
    }

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

	public String getOpportunity_Unique_Identifier() {
		return Opportunity_Unique_Identifier;
	}

	public void setOpportunity_Unique_Identifier(String opportunity_Unique_Identifier) {
		Opportunity_Unique_Identifier = opportunity_Unique_Identifier;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
    
    

}
