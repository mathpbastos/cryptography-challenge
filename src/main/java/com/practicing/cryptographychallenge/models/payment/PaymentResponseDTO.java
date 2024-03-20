package com.practicing.cryptographychallenge.models.payment;

public record PaymentResponseDTO(Long id, String creditCardToken, String userDocument, Long value) {
}
