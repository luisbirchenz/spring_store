package com.lab.orderdetail.dto;

import java.math.BigDecimal;

import com.lab.order.dto.OrderDTO;
import com.lab.product.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
	private Long orderNbr;
	private String code;
	private int quantity;
	private BigDecimal price;
	private int orderLineNbr;
	private ProductDTO product;
}
