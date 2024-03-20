package com.practicing.cryptographychallenge.models.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userDocument;
	private String creditCardToken;
	private Long value;

	public Payment(){}

	public Payment(String userDocument, String creditCardToken, Long value) {
		this.userDocument = userDocument;
		this.creditCardToken = creditCardToken;
		this.value = value;
	}

	public Payment(Long id, String userDocument, String creditCardToken, Long value) {
		this.id = id;
		this.userDocument = userDocument;
		this.creditCardToken = creditCardToken;
		this.value = value;
	}

	public String getUserDocument() {
		return userDocument;
	}

	public void setUserDocument(String userDocument) {
		this.userDocument = userDocument;
	}
	
	public String getCreditCardToken() {
		return creditCardToken;
	}
	
	public void setCreditCardToken(String creditCardToken) {
		this.creditCardToken = creditCardToken;
	}
	
	public Long getValue() {
		return value;
	}
	
	public void setValue(Long value) {
		this.value = value;
	}
	
	public Long getId() {
		return id;
	}

}
