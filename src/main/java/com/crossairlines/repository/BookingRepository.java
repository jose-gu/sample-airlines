package com.crossairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crossairlines.model.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    
}