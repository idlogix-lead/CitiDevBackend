package com.citidev.services;

import java.util.List;
import java.util.stream.Collectors;
import com.citidev.client.dto.AppliedPaymentRawDTO;
import com.citidev.client.impl.AppliedPaymentApi;
import com.citidev.dto.AppliedPaymentDTO;
import com.citidev.services.transformers.AppliedPaymentTransformer;

public class AppliedPaymentService {
	
	private final AppliedPaymentApi appliedPaymentApi;

    public AppliedPaymentService() {
    	this.appliedPaymentApi = new AppliedPaymentApi();
    }

    public List<AppliedPaymentDTO> getAppliedPayments() {
        List<AppliedPaymentRawDTO> rawAccounts = appliedPaymentApi.getAllAppliedPayments();
        return rawAccounts.stream()
                .map(AppliedPaymentTransformer::toDTO)
                .collect(Collectors.toList());
    }

}
