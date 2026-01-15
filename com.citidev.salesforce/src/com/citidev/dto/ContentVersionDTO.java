package com.citidev.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentVersionDTO {
	public static final String COLUMNNAME_Id = "Id";
	public static final String COLUMNNAME_ContentDocumentId = "ContentDocumentId";
	
	
	@JsonProperty(COLUMNNAME_Id)
    private String id;
	
	@JsonProperty(COLUMNNAME_ContentDocumentId)
    private String contentdocumentId;

   
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContentdocumentId() {
		return contentdocumentId;
	}

	public void setContentdocumentId(String contentdocumentId) {
		this.contentdocumentId = contentdocumentId;
	}
	
	

	
    
}
