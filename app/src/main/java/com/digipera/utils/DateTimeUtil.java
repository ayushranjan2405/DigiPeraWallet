package com.digipera.utils;

import com.digipera.commons.Formatter;

import java.time.LocalDate;


public class DateTimeUtil {

    public static String getSystemDate() {
        LocalDate date = LocalDate.now();
        String month = Formatter.toFirstCharUpperCase(date.getMonth().toString());
        int year = date.getYear();
        int day = date.getDayOfMonth();
        return String.format("%s %d, %d",month, day, year);
    }
}
