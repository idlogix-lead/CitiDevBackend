package com.citidev.client.api;

import java.util.List;
import java.util.Map;

import com.citidev.client.dto.AppliedReceiptRawDTO;
import com.citidev.dto.AppliedReceiptDTO;

public interface IAppliedReceiptApi {
	 List<AppliedReceiptRawDTO> getAllAppliedReceipts();
	    AppliedReceiptDTO getAppliedReceiptById(String id);
	    void updateAccount(String id,Map<String,Object> data);

}
