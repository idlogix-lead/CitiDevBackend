package com.citidev.dto;

public class AppliedPaymentDTO {
	private String id;
    private String name;
    private String lastModifiedDate;
    
    public AppliedPaymentDTO() {}
    
    public AppliedPaymentDTO(String id, String name, String lastModifiedDate) {
    	this.id = id;
        this.name = name;
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

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
    
    

}
