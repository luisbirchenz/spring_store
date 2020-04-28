package com.lab.product.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
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
