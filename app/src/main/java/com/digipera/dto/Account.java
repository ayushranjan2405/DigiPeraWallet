package com.digipera.dto;

public class Account {

    private final String balance;
    private final String rewardPoints;
    private final String dailyScreenTime;
    private final String dailyActivityTime;
    private final String relation;

    public Account(String balance, String rewardPoints, String dailyScreenTime, String dailyActivityTime, String relation) {
        this.balance = balance;
        this.rewardPoints = rewardPoints;
        this.dailyScreenTime = dailyScreenTime;
        this.dailyActivityTime = dailyActivityTime;
        this.relation = relation;
    }

    public String getBalance() {
        return balance;
    }

    public String getRewardPoints() {
        return rewardPoints;
    }

    public String getDailyScreenTime() {
        return dailyScreenTime;
    }

    public String getDailyActivityTime() {
        return dailyActivityTime;
    }

    public String getRelation() {
        return relation;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance='" + balance + '\'' +
                ", rewardPoints='" + rewardPoints + '\'' +
                ", dailyScreenTime='" + dailyScreenTime + '\'' +
                ", dailyActivityTime='" + dailyActivityTime + '\'' +
                ", relation='" + relation + '\'' +
                '}';
    }
}
