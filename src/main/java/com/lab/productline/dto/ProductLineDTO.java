package com.lab.productline.dto;

import java.util.List;

import com.lab.product.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductLineDTO {
	private Long id;
	private String productline;
	private String text;
	private String html;
	private String image;
	private List<ProductDTO> products;	
}
