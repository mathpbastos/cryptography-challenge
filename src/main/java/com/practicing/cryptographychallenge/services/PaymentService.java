package com.practicing.cryptographychallenge.services;

import java.util.List;
import java.util.Optional;

import com.practicing.cryptographychallenge.models.payment.PaymentMapper;
import com.practicing.cryptographychallenge.models.payment.PaymentRequestDTO;
import com.practicing.cryptographychallenge.models.payment.PaymentResponseDTO;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicing.cryptographychallenge.models.payment.Payment;
import com.practicing.cryptographychallenge.repositories.PaymentRepository;

@Service
public class PaymentService implements IPaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private AES256TextEncryptor aes256TextEncryptor;

	@Autowired
	private PaymentMapper paymentMapper;

	@Override
	public Optional<PaymentResponseDTO> create(PaymentRequestDTO paymentRequestDTO) {
		Payment payment = this.paymentMapper.convertToPayment(paymentRequestDTO);
		payment = this.paymentRepository.save(payment);

		PaymentResponseDTO responseDTO = this.paymentMapper.convertToPaymentResponse(payment);
		return Optional.of(responseDTO);
	}

	@Override
	public Optional<PaymentResponseDTO> update(Long id, PaymentRequestDTO paymentRequestDTO) {
		Optional<Payment> fetched = this.paymentRepository.findById(id);
		
		if(fetched.isEmpty())
			return Optional.empty();
		
		Payment updatedPayment = fetched.get();
		updatedPayment.setUserDocument(this.paymentMapper.encrypt(paymentRequestDTO.userDocument()));
		updatedPayment.setCreditCardToken(this.paymentMapper.encrypt(paymentRequestDTO.creditCardToken()));
		updatedPayment.setValue(paymentRequestDTO.value());
		
		this.paymentRepository.save(updatedPayment);

		PaymentResponseDTO paymentResponseDTO = this.paymentMapper.convertToPaymentResponse(updatedPayment);

		return Optional.of(paymentResponseDTO);
	}

	@Override
	public void delete(Long id) {
		this.paymentRepository.deleteById(id);
	}

	@Override
	public Optional<PaymentResponseDTO> getById(Long id) {
		Optional<Payment> fetched = this.paymentRepository.findById(id);
		if(fetched.isEmpty())
			return Optional.empty();

		PaymentResponseDTO paymentResponseDTO = this.paymentMapper.convertToPaymentResponse(fetched.get());

		return Optional.of(paymentResponseDTO);
	}
	
}