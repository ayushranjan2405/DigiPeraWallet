package com.digipera.mockdata;

import com.digipera.DigiperaApplication;
import com.digipera.dto.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserData {
    private List<User> users = new ArrayList<>();

    private static UserData singleton;

    public static UserData getInstance(){
        if (singleton==null){
            singleton = new UserData();
        }
        return singleton;
    }

    private UserData() {
        users.add(new User("shilpi", "Shilpi", "Singh", "32", "parent"));
        users.add(new User("ishita", "Ishita", "Singh", "16", "dependent"));
        users.add(new User("rohan", "Rohan", "Singh", "13", "dependent"));
    }

    public User getUser(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }

    public List<User> getAllUsers(){
        return users;
    }
}
