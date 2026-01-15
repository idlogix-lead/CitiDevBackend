package com.citidev.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CaseDTO {
	public static final String COLUMNNAME_Id = "Id";
    private static final String COLUMNNAME_CaseNumber = "CaseNumber";
    private static final String COLUMNNAME_Subject = "Subject";
    private static final String COLUMNNAME_Status = "Status";
    private static final String COLUMNNAME_Priority = "Priority";
    public static final String COLUMNNAME_LastModifiedDate = "LastModifiedDate";
    
 // ====== Fields ======
    @JsonProperty(COLUMNNAME_Id)
    private String Id;
    
    @JsonProperty(COLUMNNAME_CaseNumber)
    private String CaseNumber;

    @JsonProperty(COLUMNNAME_Subject)
    private String Subject;

    @JsonProperty(COLUMNNAME_Status)
    private String Status;
    
    @JsonProperty(COLUMNNAME_Priority)
    private String Priority;
    
    @JsonProperty(COLUMNNAME_LastModifiedDate)
    private String LastModifiedDate;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
	
	public String getCaseNumber() {
		return CaseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		CaseNumber = caseNumber;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getPriority() {
		return Priority;
	}

	public void setPriority(String priority) {
		Priority = priority;
	}

	public String getLastModifiedDate() {
		return LastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}
	
}
