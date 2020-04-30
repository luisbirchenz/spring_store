package com.lab.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentIdDTO {
	private Long customerNumber;
	private String checkNumber;
}
