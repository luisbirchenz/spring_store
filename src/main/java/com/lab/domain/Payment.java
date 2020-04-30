package com.lab.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
@Entity(name = "payments")
public class Payment {

	@EmbeddedId
	private PaymentId paymentId;
	
	@Column(name = "payment_date")
	private LocalDate paymentDate;
	
	@Column(name = "amount")
	private BigDecimal amount;
}
