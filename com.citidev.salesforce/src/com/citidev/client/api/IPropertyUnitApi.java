package com.citidev.client.api;


import java.util.List;
import java.util.Map;

import com.citidev.dto.PropertyUnitDTO;

public interface IPropertyUnitApi {
    List<PropertyUnitDTO> getAllPropertyUnits();
    PropertyUnitDTO getPropertyUnitById(String id);
    void updatePropertyUnit(String id,Map<String,Object> data);
}

