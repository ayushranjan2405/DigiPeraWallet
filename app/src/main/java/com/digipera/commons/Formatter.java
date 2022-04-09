package com.digipera.commons;

import com.digipera.dto.Dependent;
import com.digipera.dto.User;

public class Formatter {

    public static String getWelcomeMessage(String firstname) {
        return String.format(Constants.WELCOME_MESSAGE, firstname);
    }

    public static String toFirstCharUpperCase(String name) {
        //To be safe 1st changing all characters to lowercase
        // and then changing 1st character to uppercase
        String toLowerCase = name.toLowerCase();
        return toLowerCase.substring(0, 1).toUpperCase() + toLowerCase.substring(1);
    }

    public static String getInitials(User user) {
        return user.getFirstname().substring(0, 1) + user.getLastname().substring(0, 1);
    }

    public static String getInitials(Dependent dependent) {
        return dependent.getFirstname().substring(0, 1) + dependent.getLastname().substring(0, 1);
    }

    public static String getBalance(String balance) {
        return Constants.BALANCE_TEXT + balance;
    }

    public static String getRewards(String rewardPoints) {
        return Constants.REWARD_TEXT + rewardPoints;
    }
}
