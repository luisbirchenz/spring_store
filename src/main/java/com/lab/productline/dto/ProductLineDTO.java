package com.lab.productline.dto;

import java.util.List;

import com.lab.product.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
public class ProductLineDTO {
	private Long id;
	private String productline;
	private String text;
	private String description;
	private String image;
	private List<ProductDTO> products;	
	private Long version;
}
