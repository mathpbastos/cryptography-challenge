package com.practicing.cryptographychallenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practicing.cryptographychallenge.models.payment.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	public List<Payment> findAllByCreditCardToken(String creditCardToken);
	
}
