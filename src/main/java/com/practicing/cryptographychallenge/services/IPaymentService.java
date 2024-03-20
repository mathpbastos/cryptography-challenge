package com.practicing.cryptographychallenge.services;

import java.util.List;
import java.util.Optional;

import com.practicing.cryptographychallenge.models.payment.Payment;
import com.practicing.cryptographychallenge.models.payment.PaymentRequestDTO;
import com.practicing.cryptographychallenge.models.payment.PaymentResponseDTO;

public interface IPaymentService {

	public Optional<PaymentResponseDTO> create(PaymentRequestDTO paymentRequestDTO);
	
	public Optional<PaymentResponseDTO> update(Long id, PaymentRequestDTO paymentRequestDTO);
	
	public void delete(Long id);
	
	public Optional<PaymentResponseDTO> getById(Long id);

}
