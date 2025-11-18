package com.crossairlines.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
    
    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public static LocalDate parseDate(String dateString) {
        try {
            return LocalDate.parse(dateString, DEFAULT_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateString + ". Expected format: yyyy-MM-dd", e);
        }
    }
    
    public static int compareDates(LocalDate date1, LocalDate date2) {
        return date1.compareTo(date2);
    }
    
    public static String formatDate(LocalDate date) {
        return date.format(DEFAULT_FORMATTER);
    }
}