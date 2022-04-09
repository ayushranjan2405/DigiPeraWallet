package com.digipera.services;

import android.util.Log;

import com.digipera.dto.Account;
import com.digipera.mockdata.AccountData;

public class AccountService {

    public static Account getAccount(String username) {
        Log.i("Account_Service: ", username);
        AccountData accountData = new AccountData();
        return accountData.getAccount(username);
    }

}
