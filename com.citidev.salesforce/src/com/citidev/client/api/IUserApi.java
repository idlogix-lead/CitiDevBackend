package com.citidev.client.api;


import java.util.List;
import java.util.Map;

import com.citidev.dto.AccountDTO;

public interface IUserApi {
    List<AccountDTO> getAllAccounts();
    AccountDTO getAccountById(String id);
    void updateAccount(String id,Map<String,Object> data);
}

