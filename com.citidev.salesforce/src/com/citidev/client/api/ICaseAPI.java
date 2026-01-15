package com.citidev.client.api;

import java.util.List;
import java.util.Map;

import com.citidev.dto.CaseDTO;

public interface ICaseAPI {
	
    List<CaseDTO> getAllCases();
    CaseDTO getCaseById(String id);   
    CaseDTO createCase(CaseDTO dto);
    CaseDTO updateCase(String id, CaseDTO dto);
    boolean deleteCase(String id);
	void updateCase(String id, Map<String, Object> data);

}
