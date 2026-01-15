package com.citidev.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyUnitRawDTO {
	
	public static final String COLUMNNAME_Id = "Id";
	public static final String COLUMNNAME_Name = "Name";
	public static final String COLUMNNAME_Project_ID = "Project_ID__c";
	public static final String COLUMNNAME_Net_Total_Price__c = "Net_Total_Price__c";
	public static final String COLUMNNAME_Unit_Status = "Unit_Status__c";
	public static final String COLUMNNAME_Unit_Type = "Unit_Type__c";
	public static final String COLUMNNAME_Unit_Usage = "Unit_Usage__c";
	public static final String COLUMNNAME_LastModifiedDate = "LastModifiedDate";

	

    @JsonProperty(COLUMNNAME_Id)
    private String id;

    @JsonProperty(COLUMNNAME_Name)
    private String name;
    
    @JsonProperty(COLUMNNAME_Project_ID)
    private String projectID;
    
    @JsonProperty(COLUMNNAME_Net_Total_Price__c)
    private String unitPrice;

    @JsonProperty(COLUMNNAME_Unit_Status)
    private String unit_status;
    
    @JsonProperty(COLUMNNAME_Unit_Type)
    private String unit_type;
    
    @JsonProperty(COLUMNNAME_Unit_Usage)
    private String unit_usage;
    
    @JsonProperty(COLUMNNAME_LastModifiedDate)
    private String LastModifiedDate;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit_status() {
		return unit_status;
	}

	public void setUnit_status(String unit_status) {
		this.unit_status = unit_status;
	}

	public String getUnit_type() {
		return unit_type;
	}

	public void setUnit_type(String unit_type) {
		this.unit_type = unit_type;
	}

	public String getUnit_usage() {
		return unit_usage;
	}

	public void setUnit_usage(String unit_usage) {
		this.unit_usage = unit_usage;
	}

	public String getLastModifiedDate() {
		return LastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}

	
 
	
    
}

