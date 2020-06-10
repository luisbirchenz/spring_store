package com.lab.payment.api;

import static java.util.Objects.requireNonNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.domain.PaymentId;
import com.lab.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/payment")
@RequiredArgsConstructor
public class PaymentRestController {
	
	private final PaymentService paymentService;

	@GetMapping("/{customernbr}/{checknbr}")
	public ResponseEntity<?> findById(@PathVariable("customernbr") Long customernbr,
			@PathVariable("checknbr") String checknbr) {
		requireNonNull(customernbr);
		requireNonNull(checknbr);
		return paymentService.findById(new PaymentId(customernbr, checknbr)).map(
				dto -> {					
					try {
						return ResponseEntity
								.ok()
								.eTag(dto.getPaymentDate().toString())
								.location(new URI("api/payment/" + dto.getCustomerNumber()))
								.body(dto);
					} catch(URISyntaxException e) {
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
					}
				}).orElse(ResponseEntity.notFound().build());
	}
	
}
