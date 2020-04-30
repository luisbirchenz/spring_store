package com.lab.payment.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
	private Long customerNumber;
	private String checkNumber;
	private LocalDate paymentDate;
	private BigDecimal amount;
}
