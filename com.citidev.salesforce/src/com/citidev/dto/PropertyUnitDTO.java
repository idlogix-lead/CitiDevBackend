package com.citidev.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyUnitDTO  {
    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Project_ID__c")
    private String projectId;
    @JsonProperty("Net_Total_Price__c")
    private String unitPrice;
    @JsonProperty("Unit_Status__c")
    private String unitStatus;
    @JsonProperty("Unit_Type__c")
    private String unitType;
    @JsonProperty("LastModifiedDate")
    private String lastModifiedDate;
    
    @JsonProperty("Unit_Usage__c")
    private String unitUsage;
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
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getUnitStatus() {
		return unitStatus;
	}
	public void setUnitStatus(String unitStatus) {
		this.unitStatus = unitStatus;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getUnitUsage() {
		return unitUsage;
	}
	public void setUnitUsage(String unitUsage) {
		this.unitUsage = unitUsage;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public Map<String, Object> getUploadPayload() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", getName());
        return map;
    }
    
    
}

