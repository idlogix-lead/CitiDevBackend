package com.citidev.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentTermDTO {
	public static final String COLUMNNAME_Id = "Id";
	public static final String COLUMNNAME_Name = "Name";
	public static final String COLUMNNAME_PaymentPlanName = "Payment_Plan_Name__c";
	public static final String COLUMNNAME_CreatedDate = "CreatedDate";
	public static final String COLUMNNAME_DownPayment = "Down_payment__c";
	public static final String COLUMNNAME_On_SPA_30_days_after_Booking__c = "On_SPA_30_days_after_Booking__c";
	public static final String COLUMNNAME_Number_of_Instalments_for_Pre_HO__c = "Number_of_Instalments_for_Pre_HO__c";
	public static final String COLUMNNAME_Pre_HO_Instalment__c = "Pre_HO_Instalment__c";
	public static final String COLUMNNAME_On_HO_Instalment__c = "On_HO_Instalment__c";
	public static final String COLUMNNAME_Number_of_Instalments_for_Post_HO__c = "Number_of_Instalments_for_Post_HO__c";
	public static final String COLUMNNAME_Post_HO_Instalment__c = "Post_HO_Instalment__c";
	public static final String COLUMNNAME_LastModifiedDate = "LastModifiedDate";
	
	@JsonProperty(COLUMNNAME_Id)
    private String id;

    @JsonProperty(COLUMNNAME_Name)
    private String name;
    
    @JsonProperty(COLUMNNAME_PaymentPlanName)
    private String payment_plan_name;
    
    @JsonProperty(COLUMNNAME_CreatedDate)
    private String created_date;
    
    @JsonProperty(COLUMNNAME_DownPayment)
    private String down_payment;
    
    @JsonProperty(COLUMNNAME_On_SPA_30_days_after_Booking__c)
    private String on_spa_30_days_after_booking__c;
    
    @JsonProperty(COLUMNNAME_Number_of_Instalments_for_Pre_HO__c)
    private String number_of_instalments_for_pre_ho__c;
    
    @JsonProperty(COLUMNNAME_Pre_HO_Instalment__c)
    private String pre_ho_instalment__c;
    
    @JsonProperty(COLUMNNAME_On_HO_Instalment__c)
    private String on_ho_instalment__c;
    
    @JsonProperty(COLUMNNAME_Number_of_Instalments_for_Post_HO__c)
    private String number_of_instalments_for_post_ho__c;
    
    @JsonProperty(COLUMNNAME_Post_HO_Instalment__c)
    private String post_ho_instalment__c;
    
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

	public String getPayment_plan_name() {
		return payment_plan_name;
	}

	public void setPayment_plan_name(String payment_plan_name) {
		this.payment_plan_name = payment_plan_name;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getDown_payment() {
		return down_payment;
	}

	public void setDown_payment(String down_payment) {
		this.down_payment = down_payment;
	}

	public String getOn_spa_30_days_after_booking__c() {
		return on_spa_30_days_after_booking__c;
	}

	public void setOn_spa_30_days_after_booking__c(String on_spa_30_days_after_booking__c) {
		this.on_spa_30_days_after_booking__c = on_spa_30_days_after_booking__c;
	}

	public String getNumber_of_instalments_for_pre_ho__c() {
		return number_of_instalments_for_pre_ho__c;
	}

	public void setNumber_of_instalments_for_pre_ho__c(String number_of_instalments_for_pre_ho__c) {
		this.number_of_instalments_for_pre_ho__c = number_of_instalments_for_pre_ho__c;
	}

	public String getPre_ho_instalment__c() {
		return pre_ho_instalment__c;
	}

	public void setPre_ho_instalment__c(String pre_ho_instalment__c) {
		this.pre_ho_instalment__c = pre_ho_instalment__c;
	}

	public String getOn_ho_instalment__c() {
		return on_ho_instalment__c;
	}

	public void setOn_ho_instalment__c(String on_ho_instalment__c) {
		this.on_ho_instalment__c = on_ho_instalment__c;
	}

	public String getNumber_of_instalments_for_post_ho__c() {
		return number_of_instalments_for_post_ho__c;
	}

	public void setNumber_of_instalments_for_post_ho__c(String number_of_instalments_for_post_ho__c) {
		this.number_of_instalments_for_post_ho__c = number_of_instalments_for_post_ho__c;
	}

	public String getPost_ho_instalment__c() {
		return post_ho_instalment__c;
	}

	public void setPost_ho_instalment__c(String post_ho_instalment__c) {
		this.post_ho_instalment__c = post_ho_instalment__c;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	
	

	
	
    
    
}
