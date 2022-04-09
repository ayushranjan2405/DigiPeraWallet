package com.digipera.services;

import android.content.Intent;
import android.widget.Toast;

import com.digipera.activities.Dashboard;
import com.digipera.activities.DependentDashboard;
import com.digipera.activities.Signin;
import com.digipera.commons.Constants;
import com.digipera.dto.User;
import com.digipera.mockdata.UserData;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    public static User authenticate(String username, String password) {

        if (isUserValid(username, password)) {
            return getUser(username);
        } else {
            return null;
        }

    }

    private static boolean isUserValid(String username, String passwordStr) {
        if (username.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private static User getUser(String username) {
        UserData userData = new UserData();
        return userData.getUser(username.toLowerCase());
    }

}
