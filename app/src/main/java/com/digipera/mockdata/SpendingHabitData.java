package com.digipera.mockdata;

import com.digipera.dto.SpendingHabit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpendingHabitData {

    private final List<String> category;
    private final List<Integer> previousMonth;
    private final List<Integer> currentMonth;

    public SpendingHabitData(){
        category = new ArrayList<>();
        previousMonth = new ArrayList<>();
        currentMonth = new ArrayList<>();
        category.add("Food");
        category.add("Transport");
        category.add("Books");
        category.add("Sports");
        Random rand = new Random();

        for(int i=0; i<category.size(); i++){
            previousMonth.add(rand.nextInt(2550 - 1500) + 1500);
            currentMonth.add(rand.nextInt(2550 - 1520) + 1520);
        }
    }

    public SpendingHabit getSpendingData(){
        return new SpendingHabit(category, previousMonth, currentMonth);
    }
}
