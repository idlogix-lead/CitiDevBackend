package com.citidev.client.api;

import java.util.List;
import java.util.Map;
import com.citidev.dto.BuildingDTO;

public interface IBuildingApi {
	List<BuildingDTO> getAllBuildings();
    BuildingDTO getBuildingById(String id);
    void updateBuilding(String id,Map<String,Object> data);

}
