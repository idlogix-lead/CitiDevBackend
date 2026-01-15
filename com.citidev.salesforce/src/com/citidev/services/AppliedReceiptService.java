package com.citidev.services;

import java.util.List;
import java.util.stream.Collectors;

import com.citidev.client.dto.AppliedReceiptRawDTO;
import com.citidev.client.impl.AccountApi;
import com.citidev.client.impl.AppliedReceiptApi;
import com.citidev.dto.AppliedReceiptDTO;
import com.citidev.services.transformers.AppliedReceiptTransformer;

public class AppliedReceiptService {
	
	private final AppliedReceiptApi appliedReceiptApi;

    public AppliedReceiptService() {
    	this.appliedReceiptApi = new AppliedReceiptApi();
    }

    public List<AppliedReceiptDTO> getAppliedReceipts() {
        List<AppliedReceiptRawDTO> rawAccounts = appliedReceiptApi.getAllAppliedReceipts();
        return rawAccounts.stream()
                .map(AppliedReceiptTransformer::toDTO)
                .collect(Collectors.toList());
    }

}
