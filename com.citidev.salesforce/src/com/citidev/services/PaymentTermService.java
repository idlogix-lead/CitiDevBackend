package com.citidev.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.compiere.model.MPaySchedule;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;
import com.citidev.client.impl.PaymentTermApi;

import com.citidev.dto.PaymentTermDTO;

public class PaymentTermService {
	
	private final PaymentTermApi paymenttermApi;


    public PaymentTermService() {
    	this.paymenttermApi = new PaymentTermApi();
    }

    public List<PaymentTermDTO> getAllPaymentPlans() {
        return paymenttermApi.getAllPaymentPlans() ;
    }
    
    public PaymentTermDTO getPaymentPlanById(String id) {
        return paymenttermApi.getPaymentPlanById(id);
    }
    
    
    public int syncPaymentPlansFromSalesforce() {
        int processedCount = 0;
        List<PaymentTermDTO> dtos = getAllPaymentPlans();

        if (dtos.isEmpty()) return 0;

        List<String> paymentTermIds = dtos.stream().map(PaymentTermDTO::getId).collect(Collectors.toList());
        Map<String, MPaymentTerm> existingPaymentTerms = fetchExistingPaymentTerms(paymentTermIds);

        for (PaymentTermDTO dto : dtos) {
            MPaymentTerm paymentTerm = existingPaymentTerms.get(dto.getId());
            if (paymentTerm == null) {
                paymentTerm = new MPaymentTerm(Env.getCtx(), 0, null);
            	existingPaymentTerms.put(dto.getId(), paymentTerm);
            }
            paymentTerm.setName(dto.getPayment_plan_name()+" "+dto.getName());
            paymentTerm.setDescription(dto.getName());
            paymentTerm.set_ValueOfColumn("sf_uid", dto.getId());
            paymentTerm.saveEx();
            
            DB.executeUpdate(
            	    "DELETE FROM C_PaySchedule WHERE C_PaymentTerm_ID = ?",
            	    new Object[]{paymentTerm.getC_PaymentTerm_ID()},
            	    false,
            	    null
            	);
            List<Map<String, Object>> scheduleList = buildPaymentSchedule(dto);
            for (Map<String, Object> s : scheduleList) {
                MPaySchedule ps = new MPaySchedule(Env.getCtx(), 0, null);
                ps.setC_PaymentTerm_ID(paymentTerm.getC_PaymentTerm_ID());
                ps.set_ValueOfColumn("installment_no", s.get("Installment"));
                ps.setPercentage(new BigDecimal((Double) s.get("Percent")));
                ps.setGraceDays((Integer) s.get("DaysFromStart"));
                ps.setIsValid(true);
                ps.saveEx(); 
            }
            processedCount++;
        }
        return processedCount;
    }

	 private Map<String, MPaymentTerm> fetchExistingPaymentTerms(List<String> ids) {
	    	
	        Map<String, MPaymentTerm> data = new HashMap<>();
	        if (ids.isEmpty())
	            return data;
	
	        String placeholders = ids.stream().map(i -> "?").collect(Collectors.joining(","));
	        String where = "SF_UID IN (" + placeholders + ")";
	        List<MPaymentTerm> objects = new Query(Env.getCtx(), MPaymentTerm.Table_Name, where, null)
	                .setParameters(ids.toArray()) 
	                		.list();
	        objects.stream()
	        .forEach(obj -> data.put((String) obj.get_Value("SF_UID"), obj));
	        return data;
	    }
	 
	 private List<Map<String, Object>> buildPaymentSchedule(PaymentTermDTO dto) {
		    List<Map<String, Object>> schedule = new ArrayList<>();
		    int currentDay = 0;

		    double dpPercent = safeParse(dto.getDown_payment());
		    double spaPercent = safeParse(dto.getOn_spa_30_days_after_booking__c());
		    int preHoCount = safeParseInt(dto.getNumber_of_instalments_for_pre_ho__c());
		    double preHoPercent = safeParse(dto.getPre_ho_instalment__c());
		    double onHoPercent = safeParse(dto.getOn_ho_instalment__c());
		    int postHoCount = safeParseInt(dto.getNumber_of_instalments_for_post_ho__c());
		    double postHoPercent = safeParse(dto.getPost_ho_instalment__c());

		 // --- Down Payment ---
		    if (dpPercent > 0) {
		        schedule.add(Map.of(
		            "Phase", "Down Payment",
		            "Installment", 1,
		            "Percent", dpPercent,
		            "DaysFromStart", currentDay
		        ));
		    }

		    // --- SPA Payment ---
		    if (spaPercent > 0) {
		        currentDay += 30;
		        schedule.add(Map.of(
		            "Phase", "SPA Payment",
		            "Installment", 1,
		            "Percent", spaPercent,
		            "DaysFromStart", currentDay
		        ));
		    }

		    // --- Pre-Handover ---
		    if (preHoCount > 0 && preHoPercent > 0) {
		        for (int i = 1; i <= preHoCount; i++) {
		            currentDay += 30;
		            schedule.add(Map.of(
		                "Phase", "Pre-Handover",
		                "Installment", i,
		                "Percent", preHoPercent,
		                "DaysFromStart", currentDay
		            ));
		        }
		    }

		    // --- On Handover ---
		    if (onHoPercent > 0) {
		        currentDay += 30;
		        schedule.add(Map.of(
		            "Phase", "On Handover",
		            "Installment", 1,
		            "Percent", onHoPercent,
		            "DaysFromStart", currentDay
		        ));
		    }

		    // --- Post-Handover ---
		    if (postHoCount > 0 && postHoPercent > 0) {
		        for (int i = 1; i <= postHoCount; i++) {
		            currentDay += 30;
		            schedule.add(Map.of(
		                "Phase", "Post-Handover",
		                "Installment", i,
		                "Percent", postHoPercent,
		                "DaysFromStart", currentDay
		            ));
		        }
		    }

		    return schedule;
		}
	 
	 private double safeParse(String value) {
		    try {
		        return value == null ? 0.0 : Double.parseDouble(value);
		    } catch (Exception e) {
		        return 0.0;
		    }
		}

	 private int safeParseInt(String value) {
		    try {
		        if (value == null || value.trim().isEmpty()) return 0;
		        return (int) Math.round(Double.parseDouble(value.trim()));
		    } catch (Exception e) {
		        return 0;
		    }
		}



}
