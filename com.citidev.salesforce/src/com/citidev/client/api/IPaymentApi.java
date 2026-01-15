package com.citidev.client.api;

import java.util.List;
import java.util.Map;

import com.citidev.client.dto.PaymentRawDTO;

import com.citidev.dto.PaymentDTO;

public interface IPaymentApi {
	
	 List<PaymentRawDTO> getAllPayments();
	    PaymentDTO getPaymentById(String id);
	    void updateAccount(String id,Map<String,Object> data);

}
