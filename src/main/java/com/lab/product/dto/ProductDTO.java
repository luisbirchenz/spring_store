package com.lab.product.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private String code;
	private String name;
	private String productline;
	private String scale;
	private String vendor;
	private String description;
	private Integer stock;
	private BigDecimal buyprice;
	private BigDecimal MSRP;
}
