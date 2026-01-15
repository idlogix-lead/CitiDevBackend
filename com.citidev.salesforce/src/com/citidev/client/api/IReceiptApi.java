package com.citidev.client.api;

import java.util.List;
import java.util.Map;

import com.citidev.dto.ReceiptDTO;

public interface IReceiptApi {

    /** 🟢 Get all receipts */
    List<ReceiptDTO> getAllReceipts();

    /** 🟢 Get a single receipt by Salesforce ID */
    ReceiptDTO getReceiptById(String id);

    /** 🟡 Create a new receipt (POST) */
    ReceiptDTO createReceipt(ReceiptDTO dto);

    /** 🟠 Update an existing receipt (PATCH/PUT) 
     * @return */
    ReceiptDTO updateReceipt(String id, ReceiptDTO dto);

    /** 🔴 Delete a receipt by ID (DELETE) */
    boolean deleteReceipt(String id);

	void updateReceipt(String id, Map<String, Object> data);
}
