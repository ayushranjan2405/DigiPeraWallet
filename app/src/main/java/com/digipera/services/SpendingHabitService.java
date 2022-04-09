package com.digipera.services;

import com.digipera.dto.SpendingHabit;
import com.digipera.mockdata.SpendingHabitData;

public class SpendingHabitService {

    public static SpendingHabit getSpendingHabit(){
        SpendingHabitData spendingHabitData = new SpendingHabitData();
        return spendingHabitData.getSpendingData();
    }
}
