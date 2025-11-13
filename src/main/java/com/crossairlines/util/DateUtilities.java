package com.crossairlines.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtilities {
    
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);
    
    public static Date parseStringToLocalDate(String dateString) {
        try {
            return SIMPLE_DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format: " + dateString, e);
        }
    }
    
    public static int compareDates(Date date1, Date date2) {
        if (date1 == null && date2 == null) {
            return 0;
        }
        if (date1 == null) {
            return -1;
        }
        if (date2 == null) {
            return 1;
        }
        return date1.compareTo(date2);
    }
    
    public static LocalDate parseToLocalDate(String dateString) {
        return LocalDate.parse(dateString, FORMATTER);
    }
    
    public static String formatDate(LocalDate date) {
        return date.format(FORMATTER);
    }
}