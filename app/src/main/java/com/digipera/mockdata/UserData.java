package com.digipera.mockdata;

import com.digipera.dto.User;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    private Map<String, User> users;

    public UserData() {
        users = new HashMap<>();
        users.put("shilpi",
                new User("shilpi", "Shilpi", "Singh", "32", "parent"));
        users.put("ishita",
                new User("ishita", "Ishita", "Singh", "16", "dependent"));
        users.put("rohan",
                new User("rohan", "Rohan", "Singh", "13", "dependent"));
    }

    public User getUser(String username) {
        return users.get(username);
    }
}
