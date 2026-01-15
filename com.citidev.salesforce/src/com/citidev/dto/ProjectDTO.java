package com.citidev.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDTO {
	
	public static final String COLUMNNAME_Id = "Id";
	public static final String COLUMNNAME_Name = "Name";
	public static final String COLUMNNAME_Bank_Name = "Bank_name__c";
	public static final String COLUMNNAME_Project_Location = "Project_Location__c";
	public static final String COLUMNNAME_LastModifiedDate = "LastModifiedDate";
	
    @JsonProperty(COLUMNNAME_Id)
    private String Id;
    
    @JsonProperty(COLUMNNAME_Name)
    private String Name;
    
    @JsonProperty(COLUMNNAME_Bank_Name)
    private String Bank_name__c;
    
    @JsonProperty(COLUMNNAME_Project_Location)
    private String Project_Location__c;
    
    @JsonProperty(COLUMNNAME_LastModifiedDate)
    private String LastModifiedDate;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBank_name__c() {
		return Bank_name__c;
	}

	public void setBank_name__c(String bank_name__c) {
		Bank_name__c = bank_name__c;
	}

	public String getProject_Location__c() {
		return Project_Location__c;
	}

	public void setProject_Location__c(String project_Location__c) {
		Project_Location__c = project_Location__c;
	}

	public String getLastModifiedDate() {
		return LastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}

}
