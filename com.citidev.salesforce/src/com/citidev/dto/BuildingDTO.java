package com.citidev.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildingDTO {
	public static final String COLUMNNAME_Id = "Id";
	public static final String COLUMNNAME_Name = "Name";
	public static final String COLUMNNAME_Project_Type = "Project_Type__c";
	public static final String COLUMNNAME_Service_Level = "Service_Level__c";
	public static final String COLUMNNAME_LastModifiedDate = "LastModifiedDate";
	
    @JsonProperty(COLUMNNAME_Id)
    private String id;

    @JsonProperty(COLUMNNAME_Name)
    private String name;

    @JsonProperty(COLUMNNAME_Project_Type)
    private String Project_Type__c;
    
    @JsonProperty(COLUMNNAME_Service_Level)
    private String Service_Level__c;
    
    @JsonProperty(COLUMNNAME_LastModifiedDate)
    private String lastModifiedDate;

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

	public String getProject_Type__c() {
		return Project_Type__c;
	}

	public void setProject_Type__c(String project_Type__c) {
		Project_Type__c = project_Type__c;
	}

	public String getService_Level__c() {
		return Service_Level__c;
	}

	public void setService_Level__c(String service_Level__c) {
		Service_Level__c = service_Level__c;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	

    
    

}
