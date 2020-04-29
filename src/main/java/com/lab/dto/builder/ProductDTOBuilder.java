package com.lab.dto.builder;

import java.math.BigDecimal;

import com.lab.product.dto.ProductDTO;

public class ProductDTOBuilder {
	private String code = "S10_1949";
	private String name = "1952 Alpine Renault 1300";
	private String productline ="Classic Cars";
	private String scale = "1:10";
	private String vendor = "Classic Metal Creations";
	private String description ="description";
	private Integer stock = 7;
	private BigDecimal buyprice = new BigDecimal(98.0);
	private BigDecimal MSRP = new BigDecimal(214.0);

	private ProductDTOBuilder() {
		
	}
    
	public static ProductDTOBuilder builder() {
        return new ProductDTOBuilder();
    }
	
	public ProductDTO build() {
		return new ProductDTO(	this.code, 
								this.name, 
								this.productline, 
								this.scale, 
								this.vendor, 
								this.description, 
								this.stock, 
								this.buyprice, 
								this.MSRP);
	}
	
	public ProductDTOBuilder code(String code) {
		this.code = code;
		return this;
	}
	public ProductDTOBuilder name(String name) {
		this.name = name;
		return this;
	}
	public ProductDTOBuilder productline(String productline) {
		this.productline = productline;
		return this;
	}
	public ProductDTOBuilder scale(String scale) {
		this.scale = scale;
		return this;
	}
	public ProductDTOBuilder vendor(String vendor) {
		this.vendor = vendor;
		return this;
	}
	public ProductDTOBuilder description(String description) {
		this.description = description;
		return this;
	}
	public ProductDTOBuilder stock(Integer stock) {
		this.stock = stock;
		return this;
	}
	public ProductDTOBuilder buyprice(BigDecimal buyprice) {
		this.buyprice = buyprice;
		return this;
	}
	public ProductDTOBuilder MSRP(BigDecimal MSRP) {
		this.MSRP = MSRP;
		return this;
	}
}



