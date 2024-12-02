package com.example.Astrology.util;

import java.time.Month;

public class MonthUtil {
    public static int convertMonthNameToInt(String monthName) {
        monthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1).toLowerCase();
        Month month = Month.valueOf(monthName.toUpperCase());
        return month.getValue();
    }
}
