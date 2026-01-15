package com.citidev.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceRawDTO {

    public static final String COLUMNNAME_Id = "Id";
    public static final String COLUMNNAME_Name = "Name";
    public static final String COLUMNNAME_Account = "Account__c";
    public static final String COLUMNNAME_DueDate__c = "DueDate__c";
    public static final String COLUMNNAME_InvoiceDate__c = "InvoiceDate__c";
    public static final String COLUMNNAME_Installment__c = "Installment__c";
    public static final String COLUMNNAME_InvoiceAmount__c = "InvoiceAmount__c";
    public static final String COLUMNNAME_Opportunity__c = "Opportunity__c";
    public static final String COLUMNNAME_Unit__c = "Unit__c";
    public static final String COLUMNNAME_AppliedAmount__c = "AppliedAmount__c";

    @JsonProperty(COLUMNNAME_Id)
    private String id;

    @JsonProperty(COLUMNNAME_Name)
    private String name;

    @JsonProperty(COLUMNNAME_Account)
    private String account;

    @JsonProperty(COLUMNNAME_DueDate__c)
    private String dueDate;

    @JsonProperty(COLUMNNAME_InvoiceDate__c)
    private String invoiceDate;

    @JsonProperty(COLUMNNAME_Installment__c)
    private String installment;

    @JsonProperty(COLUMNNAME_InvoiceAmount__c)
    private Double invoiceAmount;

    @JsonProperty(COLUMNNAME_Opportunity__c)
    private String opportunity;

    @JsonProperty(COLUMNNAME_Unit__c)
    private String unit;

    @JsonProperty(COLUMNNAME_AppliedAmount__c)
    private Double appliedAmount;

    // Getters and Setters

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(String opportunity) {
        this.opportunity = opportunity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getAppliedAmount() {
        return appliedAmount;
    }

    public void setAppliedAmount(Double appliedAmount) {
        this.appliedAmount = appliedAmount;
    }
}
