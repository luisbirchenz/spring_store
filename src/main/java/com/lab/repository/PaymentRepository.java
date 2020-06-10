package com.lab.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.domain.Payment;
import com.lab.domain.PaymentId;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, PaymentId>{
	//Optional<Payment> findById(PaymentId id);
}
