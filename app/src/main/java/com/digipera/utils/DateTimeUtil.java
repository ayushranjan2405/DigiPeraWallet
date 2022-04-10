package com.digipera.utils;

import com.digipera.commons.Formatter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;


public class DateTimeUtil {

    public static String getSystemDate() {
        LocalDate date = LocalDate.now();
        String month = Formatter.toFirstCharUpperCase(date.getMonth().toString());
        int year = date.getYear();
        int day = date.getDayOfMonth();
        return String.format("%s %d, %d",month, day, year);
    }

    public static String getDate(Long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd-MM-yyyy", Locale.US);
        return sdf.format(new Date(date));

    }
}
