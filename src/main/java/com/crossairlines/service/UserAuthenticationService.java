package com.crossairlines.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossairlines.model.User;
import com.crossairlines.repository.UserRepository;
import com.crossairlines.security.JwtTokenProvider;

@Service
public class UserAuthenticationService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public boolean validateUserSession(HttpServletRequest request) {
        Cookie loginCookie = checkLoginCookie(request);
        if (loginCookie == null || loginCookie.getValue() == null) {
            return false;
        }
        
        try {
            String cookieValue = loginCookie.getValue();
            // If cookie contains JWT token
            if (jwtTokenProvider.isTokenValid(cookieValue)) {
                return true;
            }
            
            // If cookie contains user ID (legacy support)
            try {
                int userId = Integer.parseInt(cookieValue);
                User user = userRepository.findById(userId).orElse(null);
                return user != null;
            } catch (NumberFormatException e) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public Cookie checkLoginCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("loginidCookie".equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public String redirectToLogin() {
        return "/login";
    }
}