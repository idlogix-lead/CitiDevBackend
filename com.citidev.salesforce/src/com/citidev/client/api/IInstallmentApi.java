package com.citidev.client.api;

import java.util.List;
import java.util.Map;
import com.citidev.dto.InstallmentDTO;

public interface IInstallmentApi {
	 List<InstallmentDTO> getAllInstallments();
    InstallmentDTO getInstallmentById(String id);
    void updateInstallment(String id,Map<String,Object> data);

}
