package com.digipera.mockdata;

import com.digipera.dto.Account;
import com.digipera.dto.User;

import java.util.HashMap;
import java.util.Map;

public class AccountData {

    private Map<String, Account> accountsTable;

    public AccountData() {
        accountsTable = new HashMap<>();
        accountsTable.put("shilpi",
                new Account("5000", "0", "0", "0", "parent"));
        accountsTable.put("ishita",
                new Account("3000", "70", "1h 10m", "0", "dependent"));
        accountsTable.put("rohan",
                new Account("2000", "60", "2h 15m", "0", "dependent"));
    }

    public Account getAccount(String key) {
        return accountsTable.get(key);
    }
}
