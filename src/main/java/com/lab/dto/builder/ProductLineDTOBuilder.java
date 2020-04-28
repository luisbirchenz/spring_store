package com.lab.dto.builder;

import java.util.Collections;
import java.util.List;

import com.lab.product.dto.ProductDTO;
import com.lab.productline.dto.ProductLineDTO;

public class ProductLineDTOBuilder {
	private Long id = 1L;
	private String productline = "Classic Cars";
	private String text = "Text";
	private String description = "description";
	private String image = "image";
	private List<ProductDTO> products = Collections.emptyList();
	
	private ProductLineDTOBuilder() {
		
	}
	
	public static ProductLineDTOBuilder builder() {
		return new ProductLineDTOBuilder();
	}
	
	public ProductLineDTO build() {
		return new ProductLineDTO(
					this.id,
					this.productline,
					this.text,
					this.description,
					this.image,
					this.products
				);
	}

	public ProductLineDTOBuilder id( Long id) {
		this.id = id;
		return this;
	}
	public ProductLineDTOBuilder productline(String productline) {
		this.productline = productline;
		return this;
	}
	public ProductLineDTOBuilder text(String text) {
		this.text = text;
		return this;
	}
	public ProductLineDTOBuilder description(String description) {
		this.description = description;
		return this;
	}
	public ProductLineDTOBuilder image(String image) {
		this.image = image;
		return this;		
	}
	public ProductLineDTOBuilder products(List<ProductDTO> products) {
		this.products = products;
		return this;
	}
	
}
