package com.crossairlines.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    public boolean validateLoginCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("loginidCookie".equals(cookie.getName()) && cookie.getValue() != null) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public String extractUserFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("loginidCookie".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}