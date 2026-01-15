package com.citidev.services;

import java.util.List;
import java.util.stream.Collectors;

import com.citidev.client.dto.PaymentRawDTO;
import com.citidev.client.impl.AccountApi;
import com.citidev.client.impl.PaymentApi;
import com.citidev.dto.PaymentDTO;
import com.citidev.services.transformers.PaymentTransformer;

public class PaymentService {
	
	private final PaymentApi paymentApi;

    public PaymentService() {
    	this.paymentApi = new PaymentApi();
    }

    public List<PaymentDTO> getPayments() {
        List<PaymentRawDTO> rawAccounts = paymentApi.getAllPayments();
        return rawAccounts.stream()
                .map(PaymentTransformer::toDTO)
                .collect(Collectors.toList());
    }

}
