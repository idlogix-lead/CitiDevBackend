package com.citidev.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpportunityDTO {
	public static final String COLUMNNAME_Id = "Id";
	public static final String COLUMNNAME_Name = "Name";
	public static final String COLUMNNAME_CloseDate = "CloseDate";
	public static final String COLUMNNAME_AccountId = "AccountId";
	public static final String COLUMNNAME_Tower_UnitC = "Tower_Unit__c";
	public static final String COLUMNNAME_LastModifiedDate = "LastModifiedDate";
	
	
	@JsonProperty(COLUMNNAME_Id)
    private String id;

    @JsonProperty(COLUMNNAME_Name)
    private String name;
    
    @JsonProperty(COLUMNNAME_CloseDate)
    private String closedate;
    
    @JsonProperty(COLUMNNAME_AccountId)
    private String account;
    
    @JsonProperty(COLUMNNAME_Tower_UnitC)
    private String tower_unit_c;
    
    @JsonProperty(COLUMNNAME_LastModifiedDate)
    private String lastModifiedDate;
    
    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClosedate() {
		return closedate;
	}

	public void setClosedate(String closedate) {
		this.closedate = closedate;
	}

	public String getTower_unit_c() {
		return tower_unit_c;
	}

	public void setTower_unit_c(String tower_unit_c) {
		this.tower_unit_c = tower_unit_c;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	
	
	
	

	
	
    
    
}
