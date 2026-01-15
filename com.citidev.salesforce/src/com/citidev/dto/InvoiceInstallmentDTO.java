package com.citidev.dto;

public class InvoiceInstallmentDTO {

    // --- Invoice Fields ---
    private String invoiceId;
    private String invoiceName;
    private String invoiceDueDate;
    private String invoiceDate;
    private Double invoiceAmount;
    private String invoiceOpportunity;
    private Double invoiceAppliedAmount;
    private Double invoiceUnappliedAmount;

    // --- Installment Fields ---
    private String installmentId;
    private String installmentName;
    private Double installmentAmount;
    private String installmentDate;
    private String installmentOpportunity;
    private String installmentUnit;
    private String installmentAccount;
    private String installmentUnitId;
    private Double installmentAllocatedAmount;
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

