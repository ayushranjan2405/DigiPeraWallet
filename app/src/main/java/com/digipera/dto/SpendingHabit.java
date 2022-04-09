package com.digipera.dto;

import java.util.List;

public class SpendingHabit {

    private final List<String> category;
    private final List<Integer> currentMonth;
    private final List<Integer> previousMonth;

    public SpendingHabit(List<String> category, List<Integer> previousMonth, List<Integer> currentMonth) {
        this.category = category;
        this.currentMonth = currentMonth;
        this.previousMonth = previousMonth;
    }

    public List<String> getCategory() {
        return category;
    }

    public List<Integer> getCurrentMonth() {
        return currentMonth;
    }

    public List<Integer> getPreviousMonth() {
        return previousMonth;
    }
}
