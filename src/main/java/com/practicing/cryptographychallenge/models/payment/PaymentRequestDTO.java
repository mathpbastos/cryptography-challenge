package com.practicing.cryptographychallenge.models.payment;

public record PaymentRequestDTO(String userDocument, String creditCardToken, Long value) {

}
