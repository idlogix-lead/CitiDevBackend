package com.citidev.client.api;

import java.util.Map;
import com.citidev.dto.ContentVersionDTO;

public interface IContentVersionApi {
//	 List<ContentVersionDTO> getAllContentVersions();
	 ContentVersionDTO getContentDocumentById(String id);
    ContentVersionDTO uploadFilesToSF(String title, String pathOnClient, byte[] fileBytes, String fileName);
    String createContentDocumentLink(Map<String,Object> fields);

}
