package com.practicing.cryptographychallenge.models.payment;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

	@Autowired
	private AES256TextEncryptor aes256TextEncryptor;

	public Payment convertToPayment(PaymentRequestDTO paymentRequestDTO) {
		return new Payment(
				this.encrypt(paymentRequestDTO.userDocument()),
				this.encrypt(paymentRequestDTO.creditCardToken()),
				paymentRequestDTO.value()
		);
	}

	public PaymentResponseDTO convertToPaymentResponse(Payment payment) {
		return new PaymentResponseDTO(
				payment.getId(),
				this.decrypt(payment.getUserDocument()),
				this.decrypt(payment.getCreditCardToken()),
				payment.getValue()
		);
	}

	public String encrypt(String str) {
		return this.aes256TextEncryptor.encrypt(str);
	}

	public String decrypt(String str) {
		return this.aes256TextEncryptor.decrypt(str);
	}
	
}
