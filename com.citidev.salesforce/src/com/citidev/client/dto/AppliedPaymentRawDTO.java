package com.citidev.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppliedPaymentRawDTO {
	public static final String COLUMNNAME_Id = "Id";
	public static final String COLUMNNAME_Name = "Name";
	
	@JsonProperty(COLUMNNAME_Id)
    private String id;

    @JsonProperty(COLUMNNAME_Name)
    private String name;
    
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
    

}
