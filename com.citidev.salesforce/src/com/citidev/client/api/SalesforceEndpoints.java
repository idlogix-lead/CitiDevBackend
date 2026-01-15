package com.citidev.client.api;

public enum SalesforceEndpoints {
	
	AUTH("/services/oauth2/token"),

    QUERY("/services/data/v61.0/query?q=%s"),              //  query
    OBJECT_BY_ID("/services/data/v61.0/sobjects/%s/%s"),   //  object, id
    CREATE_OBJECT("/services/data/v61.0/sobjects/%s"),     //  object
    UPDATE_OBJECT("/services/data/v61.0/sobjects/%s/%s"),  //  object, id
    DELETE_OBJECT("/services/data/v61.0/sobjects/%s/%s"),  //  object, id
    ALL_OBJECTS("/services/data/v61.0/sobjects");          
	
    private final String pathTemplate;

    SalesforceEndpoints(String pathTemplate) {
        this.pathTemplate = pathTemplate;
    }

    // Method to generate final URL with parameters
    public String getUrl(Object... params) {
        return   String.format(pathTemplate, params);
    }
}

