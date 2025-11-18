package com.crossairlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.crossairlines.model.User;
import com.crossairlines.repository.UserRepository;

@Service
public class UserManagementService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }
    
    public User getCurrentUserFromToken(HttpServletRequest request) {
        int userId = 0;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("loginidCookie".equals(cookie.getName())) {
                    userId = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }
        return getUserById((long) userId);
    }
}