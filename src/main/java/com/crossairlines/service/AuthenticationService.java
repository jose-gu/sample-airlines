package com.crossairlines.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossairlines.model.User;
import com.crossairlines.repository.UserRepository;
import com.crossairlines.security.JwtTokenProvider;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public boolean isUserAuthenticated(HttpServletRequest request) {
        return validateUserFromCookie(request);
    }
    
    public boolean validateUserFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("loginidCookie".equals(cookie.getName()) && cookie.getValue() != null) {
                    try {
                        int userId = Integer.parseInt(cookie.getValue());
                        return userRepository.existsById(userId);
                    } catch (NumberFormatException e) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
    
    public Integer extractUserIdFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("loginidCookie".equals(cookie.getName()) && cookie.getValue() != null) {
                    try {
                        return Integer.parseInt(cookie.getValue());
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public boolean validateUserAuthentication(HttpServletRequest request) {
        return isUserLoggedIn(request);
    }

    public User extractUserFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("loginidCookie".equals(cookie.getName()) && cookie.getValue() != null) {
                    try {
                        int userId = Integer.parseInt(cookie.getValue());
                        return userRepository.findById(userId).orElse(null);
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public boolean isUserLoggedIn(HttpServletRequest request) {
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
}