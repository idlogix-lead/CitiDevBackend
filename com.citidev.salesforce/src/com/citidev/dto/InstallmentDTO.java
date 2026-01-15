package com.citidev.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstallmentDTO {
	public static final String COLUMNNAME_Id = "Id";
	public static final String COLUMNNAME_Instalment_Date = "Instalment_Date__c";
	public static final String COLUMNNAME_Opportunity__c = "Opportunity__c";
	public static final String COLUMNNAME_AccountId = "Opportunity__r.AccountId";
	public static final String COLUMNNAME_PaymentPlan = "Opportunity_r.Payment_Plan_C";
	public static final String COLUMNNAME_Unit = "Unit__c";
	public static final String COLUMNNAME_UnallocatedAmount = "UnallocatedAmount__c";
	public static final String COLUMNNAME_LastModifiedDate = "LastModifiedDate";
	
	@JsonProperty(COLUMNNAME_Id)
    private String id;

    @JsonProperty(COLUMNNAME_Instalment_Date)
    private String installmentdate;
    
    @JsonProperty(COLUMNNAME_Opportunity__c)
    private String opportunity;
    
    @JsonProperty(COLUMNNAME_AccountId)
    private String account;
    
    @JsonProperty(COLUMNNAME_PaymentPlan)
    private String payment_plan;
    
    @JsonProperty(COLUMNNAME_Unit)
    private String unit;
    
    @JsonProperty(COLUMNNAME_UnallocatedAmount)
    private String unallocated_amount;
    
    @JsonProperty(COLUMNNAME_LastModifiedDate)
    private String lastModifiedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstallmentdate() {
		return installmentdate;
	}

	public void setInstallmentdate(String installmentdate) {
		this.installmentdate = installmentdate;
	}

	public String getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(String opportunity) {
		this.opportunity = opportunity;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnallocated_amount() {
		return unallocated_amount;
	}

	public void setUnallocated_amount(String unallocated_amount) {
		this.unallocated_amount = unallocated_amount;
	}

	public String getPayment_plan() {
		return payment_plan;
	}

	public void setPayment_plan(String payment_plan) {
		this.payment_plan = payment_plan;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	
	
    
    
}
