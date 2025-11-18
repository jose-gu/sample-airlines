package com.crossairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crossairlines.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    boolean existsById(int userId);
    
    @Query("SELECT u FROM User u WHERE u.loginId = :loginId")
    Optional<User> findByLoginId(@Param("loginId") String loginId);
}