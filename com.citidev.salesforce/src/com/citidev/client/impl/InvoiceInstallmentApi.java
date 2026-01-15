package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IInvoiceInstallmentApi;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.client.dto.InvoiceInstallmentRawDTO;
import com.citidev.dto.InvoiceInstallmentDTO;
import com.citidev.services.transformers.InvoiceInstallmentTransformer;
import com.citidev.utilities.JsonUtils;

/**
 * API implementation to fetch joined Invoice and Installment data from Salesforce.
 */
public class InvoiceInstallmentApi implements IInvoiceInstallmentApi {

    private final IApiClient apiClient;

    public InvoiceInstallmentApi() {
        this.apiClient = ApiClientProvider.getApiClient();
    }

    /**
     * Fetches a list of composite Invoice + Installment records.
     * 
     * @return List of InvoiceInstallmentRawDTO
     */
    @Override
    public List<InvoiceInstallmentRawDTO> getAllInvoiceInstallments() {
    	  try {
    		  String soql = "SELECT Id, Name, Instalment_Amount__c, Instalment_Date__c, Opportunity__c, " +
                      "Unit__c, Account__c, UnitId__c, AllocatedAmount__c, UnallocatedAmount__c, " +
                      "(SELECT Id, Name, Account__c, DueDate__c, InvoiceDate__c, Installment__c, " +
                      "InvoiceAmount__c, Opportunity__c, Unit__c, AppliedAmount__c " +
                      "FROM Invoices__r) " +
                      "FROM Installment__c where id = 'a1AOt000006nCklMAE'  limit 10";

              String encodedSoql = URLEncoder.encode(soql, StandardCharsets.UTF_8);
              String url = SalesforceEndpoints.QUERY.getUrl(encodedSoql);
              String response = apiClient.queryAll(url);

              return JsonUtils.extractFlattenedList(response, "records", InvoiceInstallmentRawDTO.class);

          } catch (Exception e) {
              throw new RuntimeException("Error fetching invoice-installment records", e);
          }
    }

    /**
     * Fetches a single composite Invoice + Installment record by Installment Id.
     */
    @Override
    public InvoiceInstallmentDTO getInvoiceInstallmentById(String installmentId) {
//        try {
//            String soql = "SELECT " +
//                    // --- Invoice Fields ---
//                    "Invoice__r.Id, " +
//                    "Invoice__r.Name, " +
//                    "Invoice__r.DueDate__c, " +
//                    "Invoice__r.InvoiceDate__c, " +
//                    "Invoice__r.InvoiceAmount__c, " +
//                    "Invoice__r.Opportunity__c, " +
//                    "Invoice__r.AppliedAmount__c, " +
//                    "Invoice__r.UnappliedAmount__c, " +
//
//                    // --- Installment Fields ---
//                    "Id, " +
//                    "Name, " +
//                    "Instalment_Amount__c, " +
//                    "Instalment_Date__c, " +
//                    "Opportunity__c, " +
//                    "Unit__c, " +
//                    "Account__c, " +
//                    "UnitId__c, " +
//                    "AllocatedAmount__c, " +
//                    "UnallocatedAmount__c " +
//                    "FROM Instalment__c " +
//                    "WHERE Id = '" + installmentId + "' " +
//                    "LIMIT 1";
//
//            String encodedSoql = URLEncoder.encode(soql, StandardCharsets.UTF_8);
//            String url = SalesforceEndpoints.QUERY.getUrl(encodedSoql);
//            String response = apiClient.queryAll(url);
//
//            InvoiceInstallmentRawDTO raw = JsonUtils.extractOne(response, "records", InvoiceInstallmentRawDTO.class);
//            return InvoiceInstallmentTransformer.toDomain(raw);
//
//        } catch (Exception e) {
//            throw new RuntimeException("Error fetching invoice-installment record with Id: " + installmentId, e);
//        }
    	return null;
    }
}

