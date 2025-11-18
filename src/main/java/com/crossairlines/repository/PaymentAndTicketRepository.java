package com.crossairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crossairlines.model.Payment;
import com.crossairlines.model.BookTicket;

@Repository
interface PaymentRepository extends JpaRepository<Payment, Long> {
}

@Repository
interface BookTicketRepository extends JpaRepository<BookTicket, Long> {
}