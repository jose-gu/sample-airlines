package com.crossairlines.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtilities {
    
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    
    public Date parseDate(String dateString) {
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format: " + dateString + ". Expected format: " + DATE_FORMAT, e);
        }
    }
    
    public int compareDates(Date date1, Date date2) {
        return date1.compareTo(date2);
    }
    
    public String formatDate(Date date) {
        return dateFormat.format(date);
    }
}