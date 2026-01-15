package com.citidev.client.api;

import java.util.List;
import java.util.Map;
import com.citidev.dto.OpportunityDTO;

public interface IOpportunityApi {
	 List<OpportunityDTO> getAllOpportunities();
	 OpportunityDTO getOpportunityById(String id);
    void updateOpportunity(String id,Map<String,Object> data);

}
