package com.citidev.client.api;

import java.util.List;
import java.util.Map;
import com.citidev.dto.PaymentTermDTO;

public interface IPaymentTermApi {
	 List<PaymentTermDTO> getAllPaymentPlans();
	 PaymentTermDTO getPaymentPlanById(String id);
    void updatePaymentPlan(String id,Map<String,Object> data);

}
