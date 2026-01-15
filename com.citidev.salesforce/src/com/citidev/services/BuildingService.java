package com.citidev.services;

import java.util.List;
import com.citidev.client.impl.BuildingApi;
import com.citidev.dto.BuildingDTO;

public class BuildingService {
	private final BuildingApi buildingApi;
	
	public BuildingService() {
    	this.buildingApi = new BuildingApi();
    }
	
	 public List<BuildingDTO> getbuildingss() {
	       return buildingApi.getAllBuildings();
	    }

}
