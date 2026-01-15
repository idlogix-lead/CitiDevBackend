package com.citidev.dto;

public class InvoiceDTO {

    private String id;
    private String name;
    private String account;
    private String dueDate;
    private String invoiceDate;
    private String installment;
    private Double invoiceAmount;
    private String opportunity;
    private String unit;
    private Double appliedAmount;
    private String lastModifiedDate;

    public InvoiceDTO() {}

    public InvoiceDTO(String id, String name, String account, String dueDate, String invoiceDate,
                      String installment, Double invoiceAmount, String opportunity, String unit,
                      Double appliedAmount,String lastModifiedDate) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.dueDate = dueDate;
        this.invoiceDate = invoiceDate;
        this.installment = installment;
        this.invoiceAmount = invoiceAmount;
        this.opportunity = opportunity;
        this.unit = unit;
        this.appliedAmount = appliedAmount;
        this.lastModifiedDate = lastModifiedDate;
    }

    // --- Getters and Setters ---

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

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
    
    
}
