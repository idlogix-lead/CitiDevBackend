package com.citidev.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceInstallmentRawDTO {

    // --- Invoice Fields ---
    public static final String COLUMNNAME_Invoice_Id = "Invoice__c";
    public static final String COLUMNNAME_Invoice_Name = "Invoice__r.Name";
    public static final String COLUMNNAME_Invoice_DueDate__c = "Invoice__r.DueDate__c";
    public static final String COLUMNNAME_Invoice_InvoiceDate__c = "Invoice__r.InvoiceDate__c";
    public static final String COLUMNNAME_Invoice_InvoiceAmount__c = "Invoice__r.InvoiceAmount__c";
    public static final String COLUMNNAME_Invoice_Opportunity__c = "Invoice__r.Opportunity__c";
    public static final String COLUMNNAME_Invoice_AppliedAmount__c = "Invoice__r.AppliedAmount__c";
    public static final String COLUMNNAME_Invoice_UnappliedAmount__c = "Invoice__r.UnappliedAmount__c";

    // --- Installment Fields ---
    public static final String COLUMNNAME_Installment_Id = "Installment__c";
    public static final String COLUMNNAME_Installment_Name = "Installment__r.Name";
    public static final String COLUMNNAME_Installment_Amount__c = "Installment__r.Instalment_Amount__c";
    public static final String COLUMNNAME_Installment_Date__c = "Installment__r.Instalment_Date__c";
    public static final String COLUMNNAME_Installment_Opportunity__c = "Installment__r.Opportunity__c";
    public static final String COLUMNNAME_Installment_Unit__c = "Installment__r.Unit__c";
    public static final String COLUMNNAME_Installment_Account__c = "Installment__r.Account__c";
    public static final String COLUMNNAME_Installment_UnitId__c = "Installment__r.UnitId__c";
    public static final String COLUMNNAME_Installment_AllocatedAmount__c = "Installment__r.AllocatedAmount__c";
    public static final String COLUMNNAME_Installment_UnallocatedAmount__c = "Installment__r.UnallocatedAmount__c";

    // --- Data Members ---
    @JsonProperty(COLUMNNAME_Invoice_Id)
    private String invoiceId;

    @JsonProperty(COLUMNNAME_Invoice_Name)
    private String invoiceName;

    @JsonProperty(COLUMNNAME_Invoice_DueDate__c)
    private String invoiceDueDate;

    @JsonProperty(COLUMNNAME_Invoice_InvoiceDate__c)
    private String invoiceDate;

    @JsonProperty(COLUMNNAME_Invoice_InvoiceAmount__c)
    private Double invoiceAmount;

    @JsonProperty(COLUMNNAME_Invoice_Opportunity__c)
    private String invoiceOpportunity;

    @JsonProperty(COLUMNNAME_Invoice_AppliedAmount__c)
    private Double invoiceAppliedAmount;

    @JsonProperty(COLUMNNAME_Invoice_UnappliedAmount__c)
    private Double invoiceUnappliedAmount;

    @JsonProperty(COLUMNNAME_Installment_Id)
    private String installmentId;

    @JsonProperty(COLUMNNAME_Installment_Name)
    private String installmentName;

    @JsonProperty(COLUMNNAME_Installment_Amount__c)
    private Double installmentAmount;

    @JsonProperty(COLUMNNAME_Installment_Date__c)
    private String installmentDate;

    @JsonProperty(COLUMNNAME_Installment_Opportunity__c)
    private String installmentOpportunity;

    @JsonProperty(COLUMNNAME_Installment_Unit__c)
    private String installmentUnit;

    @JsonProperty(COLUMNNAME_Installment_Account__c)
    private String installmentAccount;

    @JsonProperty(COLUMNNAME_Installment_UnitId__c)
    private String installmentUnitId;

    @JsonProperty(COLUMNNAME_Installment_AllocatedAmount__c)
    private Double installmentAllocatedAmount;

    @JsonProperty(COLUMNNAME_Installment_UnallocatedAmount__c)
    private Double installmentUnallocatedAmount;

    // --- Getters and Setters ---
    public String getInvoiceId() { return invoiceId; }
    public void setInvoiceId(String invoiceId) { this.invoiceId = invoiceId; }

    public String getInvoiceName() { return invoiceName; }
    public void setInvoiceName(String invoiceName) { this.invoiceName = invoiceName; }

    public String getInvoiceDueDate() { return invoiceDueDate; }
    public void setInvoiceDueDate(String invoiceDueDate) { this.invoiceDueDate = invoiceDueDate; }

    public String getInvoiceDate() { return invoiceDate; }
    public void setInvoiceDate(String invoiceDate) { this.invoiceDate = invoiceDate; }

    public Double getInvoiceAmount() { return invoiceAmount; }
    public void setInvoiceAmount(Double invoiceAmount) { this.invoiceAmount = invoiceAmount; }

    public String getInvoiceOpportunity() { return invoiceOpportunity; }
    public void setInvoiceOpportunity(String invoiceOpportunity) { this.invoiceOpportunity = invoiceOpportunity; }

    public Double getInvoiceAppliedAmount() { return invoiceAppliedAmount; }
    public void setInvoiceAppliedAmount(Double invoiceAppliedAmount) { this.invoiceAppliedAmount = invoiceAppliedAmount; }

    public Double getInvoiceUnappliedAmount() { return invoiceUnappliedAmount; }
    public void setInvoiceUnappliedAmount(Double invoiceUnappliedAmount) { this.invoiceUnappliedAmount = invoiceUnappliedAmount; }

    public String getInstallmentId() { return installmentId; }
    public void setInstallmentId(String installmentId) { this.installmentId = installmentId; }

    public String getInstallmentName() { return installmentName; }
    public void setInstallmentName(String installmentName) { this.installmentName = installmentName; }

    public Double getInstallmentAmount() { return installmentAmount; }
    public void setInstallmentAmount(Double installmentAmount) { this.installmentAmount = installmentAmount; }

    public String getInstallmentDate() { return installmentDate; }
    public void setInstallmentDate(String installmentDate) { this.installmentDate = installmentDate; }

    public String getInstallmentOpportunity() { return installmentOpportunity; }
    public void setInstallmentOpportunity(String installmentOpportunity) { this.installmentOpportunity = installmentOpportunity; }

    public String getInstallmentUnit() { return installmentUnit; }
    public void setInstallmentUnit(String installmentUnit) { this.installmentUnit = installmentUnit; }

    public String getInstallmentAccount() { return installmentAccount; }
    public void setInstallmentAccount(String installmentAccount) { this.installmentAccount = installmentAccount; }

    public String getInstallmentUnitId() { return installmentUnitId; }
    public void setInstallmentUnitId(String installmentUnitId) { this.installmentUnitId = installmentUnitId; }

    public Double getInstallmentAllocatedAmount() { return installmentAllocatedAmount; }
    public void setInstallmentAllocatedAmount(Double installmentAllocatedAmount) { this.installmentAllocatedAmount = installmentAllocatedAmount; }

    public Double getInstallmentUnallocatedAmount() { return installmentUnallocatedAmount; }
    public void setInstallmentUnallocatedAmount(Double installmentUnallocatedAmount) { this.installmentUnallocatedAmount = installmentUnallocatedAmount; }
}
