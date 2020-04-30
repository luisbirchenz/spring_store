package com.lab.customer.api;

import static java.util.Objects.requireNonNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/customer")
@RequiredArgsConstructor
public class CustomerRestController {

	private final CustomerService customerService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		requireNonNull(id);
		return customerService.findById(id).map(
				dto -> {					
					try {
						return ResponseEntity
								.ok()
								.eTag(dto.getCustomerNumber().toString())
								.location(new URI("api/customer/" + dto.getCustomerNumber()))
								.body(dto);
					} catch(URISyntaxException e) {
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
					}
				}).orElse(ResponseEntity.notFound().build());
	}
}
