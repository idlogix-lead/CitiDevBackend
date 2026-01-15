package com.citidev.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

    public static final String COLUMNNAME_Id = "Id";
    public static final String COLUMNNAME_Name = "Name";
    public static final String COLUMNNAME_FirstName = "FirstName";
    public static final String COLUMNNAME_LastName = "LastName";
    public static final String COLUMNNAME_Nationality = "Nationality__c";
    public static final String COLUMNNAME_Country_of_Residence = "Country_of_Residence__c";
    public static final String COLUMNNAME_Project_Name = "Project_Name__c";
    public static final String COLUMNNAME_PersonEmail = "PersonEmail";
    public static final String COLUMNNAME_Phone = "Phone";
    public static final String COLUMNNAME_PersonMobilePhone = "PersonMobilePhone";
    public static final String COLUMNNAME_Passport_Number = "Passport_Number__c";
    public static final String COLUMNNAME_BillingAddress = "BillingAddress";
    public static final String COLUMNNAME_LastModifiedDate = "LastModifiedDate";


    @JsonProperty(COLUMNNAME_Id)
    private String id;

    @JsonProperty(COLUMNNAME_Name)
    private String name;

    @JsonProperty(COLUMNNAME_FirstName)
    private String fname;

    @JsonProperty(COLUMNNAME_LastName)
    private String lname;

    @JsonProperty(COLUMNNAME_Nationality)
    private String nationality;

    @JsonProperty(COLUMNNAME_Country_of_Residence)
    private String countryOfResidence;

    @JsonProperty(COLUMNNAME_Project_Name)
    private String projectName;

    @JsonProperty(COLUMNNAME_PersonEmail)
    private String personEmail;

    @JsonProperty(COLUMNNAME_Phone)
    private String phone;

    @JsonProperty(COLUMNNAME_PersonMobilePhone)
    private String personMobilePhone;

    @JsonProperty(COLUMNNAME_Passport_Number)
    private String passport;

    @JsonProperty(COLUMNNAME_BillingAddress)
    private BillingAddressDTO billingAddress;
    
    @JsonProperty(COLUMNNAME_LastModifiedDate)
    private String lastModifiedDate;

    public AccountDTO() {}

    public AccountDTO(String id, String name, String nationality, String countryOfResidence,
                      String projectName, String personEmail, String phone, String personMobilePhone) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.countryOfResidence = countryOfResidence;
        this.projectName = projectName;
        this.personEmail = personEmail;
        this.phone = phone;
        this.personMobilePhone = personMobilePhone;
    }


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }

    public String getLname() { return lname; }
    public void setLname(String lname) { this.lname = lname; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getCountryOfResidence() { return countryOfResidence; }
    public void setCountryOfResidence(String countryOfResidence) { this.countryOfResidence = countryOfResidence; }

    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }

    public String getPersonEmail() { return personEmail; }
    public void setPersonEmail(String personEmail) { this.personEmail = personEmail; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPersonMobilePhone() { return personMobilePhone; }
    public void setPersonMobilePhone(String personMobilePhone) { this.personMobilePhone = personMobilePhone; }

    public String getPassport() { return passport; }
    public void setPassport(String passport) { this.passport = passport; }

    public BillingAddressDTO getBillingAddress() { return billingAddress; }
    public void setBillingAddress(BillingAddressDTO billingAddress) { this.billingAddress = billingAddress; }
    
    public String getLastModifiedDate() { return lastModifiedDate; }
    public void setLastModifiedDate(String lastModifiedDate) { this.lastModifiedDate = lastModifiedDate; }
   
 

    public Map<String, Object> getUpdatePayload() {
        Map<String, Object> payload = new HashMap<>();

        payload.put(COLUMNNAME_PersonMobilePhone, getPersonMobilePhone());
        payload.put(COLUMNNAME_PersonEmail, getPersonEmail());
        payload.put(COLUMNNAME_Country_of_Residence, getCountryOfResidence());

        if (billingAddress != null) {
            payload.put(COLUMNNAME_BillingAddress, billingAddress.toMap());
        }

        return payload;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BillingAddressDTO {
    	
    	public static final String COLUMNNAME_City = "city";
        public static final String COLUMNNAME_Country = "country";
        public static final String COLUMNNAME_GeocodeAccuracy = "geocodeAccuracy";
        public static final String COLUMNNAME_Latitude = "latitude";
        public static final String COLUMNNAME_Longitude = "longitude";
        public static final String COLUMNNAME_PostalCode = "postalCode";
        public static final String COLUMNNAME_State = "state";
        public static final String COLUMNNAME_Street = "street";

        @JsonProperty(COLUMNNAME_City)
        private String city;

        @JsonProperty(COLUMNNAME_Country)
        private String country;

        @JsonProperty(COLUMNNAME_GeocodeAccuracy)
        private String geocodeAccuracy;

        @JsonProperty(COLUMNNAME_Latitude)
        private String latitude;

        @JsonProperty(COLUMNNAME_Longitude)
        private String longitude;

        @JsonProperty(COLUMNNAME_PostalCode)
        private String postalCode;

        @JsonProperty(COLUMNNAME_State)
        private String state;

        @JsonProperty(COLUMNNAME_Street)
        private String street;

        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }

        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }

        public String getGeocodeAccuracy() { return geocodeAccuracy; }
        public void setGeocodeAccuracy(String geocodeAccuracy) { this.geocodeAccuracy = geocodeAccuracy; }

        public String getLatitude() { return latitude; }
        public void setLatitude(String latitude) { this.latitude = latitude; }

        public String getLongitude() { return longitude; }
        public void setLongitude(String longitude) { this.longitude = longitude; }

        public String getPostalCode() { return postalCode; }
        public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

        public String getState() { return state; }
        public void setState(String state) { this.state = state; }

        public String getStreet() { return street; }
        public void setStreet(String street) { this.street = street; }

        public Map<String, Object> toMap() {
            Map<String, Object> map = new HashMap<>();
            map.put(COLUMNNAME_City, city);
            map.put(COLUMNNAME_Country, country);
            map.put(COLUMNNAME_GeocodeAccuracy, geocodeAccuracy);
            map.put(COLUMNNAME_Latitude, latitude);
            map.put(COLUMNNAME_Longitude, longitude);
            map.put(COLUMNNAME_PostalCode, postalCode);
            map.put(COLUMNNAME_State, state);
            map.put(COLUMNNAME_Street, street);
            return map;
        }
    }
}

