package com.practicing.cryptographychallenge.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.practicing.cryptographychallenge.models.payment.PaymentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practicing.cryptographychallenge.models.payment.Payment;
import com.practicing.cryptographychallenge.models.payment.PaymentRequestDTO;
import com.practicing.cryptographychallenge.services.PaymentService;

import javax.swing.text.html.Option;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/new")
	public ResponseEntity<PaymentResponseDTO> create(@RequestBody PaymentRequestDTO paymentRequestDTO) {
		Optional<PaymentResponseDTO> saved = this.paymentService.create(paymentRequestDTO);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id})")
				.buildAndExpand(saved.get().id())
				.toUri();
		
		return ResponseEntity.created(location).body(saved.get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PaymentResponseDTO> update(@PathVariable("id") Long id, @RequestBody PaymentRequestDTO paymentRequestDTO) {
		Optional<PaymentResponseDTO> paymentResponseDTO = this.paymentService.update(id, paymentRequestDTO);

		if(paymentResponseDTO.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(paymentResponseDTO.get());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaymentResponseDTO> getById(@PathVariable("id") Long id) {
		Optional<PaymentResponseDTO> fetched = this.paymentService.getById(id);
		
		if(fetched.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(fetched.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PaymentResponseDTO> deleteById(@PathVariable("id") Long id) {
		Optional<PaymentResponseDTO> fetched = this.paymentService.getById(id);
		
		if(fetched.isEmpty())
			return ResponseEntity.notFound().build();
		
		this.paymentService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
