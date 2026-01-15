package com.citidev.client.api;

import java.util.List;
import java.util.Map;
import com.citidev.client.dto.AppliedPaymentRawDTO;
import com.citidev.dto.AppliedPaymentDTO;

public interface IAppliedPaymentApi {
	 List<AppliedPaymentRawDTO> getAllAppliedPayments();
	    AppliedPaymentDTO getAppliedPaymentById(String id);
	    void updateAccount(String id,Map<String,Object> data);

}
