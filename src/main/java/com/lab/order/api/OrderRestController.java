package com.lab.order.api;

import static java.util.Objects.requireNonNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.service.OrderService;

@RestController
@RequestMapping(value = "api/order")
public class OrderRestController {

	private final OrderService orderService;
	
	public OrderRestController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		requireNonNull(id);
		return orderService.findById(id).map(
				dto -> {					
					try {
						return ResponseEntity
								.ok()
								.eTag(dto.getOrderDate().toString())
								.location(new URI("api/order/" + dto.getId()))
								.body(dto);
					} catch(URISyntaxException e) {
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
					}
				}).orElse(ResponseEntity.notFound().build());
	}
	
}
