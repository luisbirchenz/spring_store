package com.lab.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
@Entity(name = "products")
public class Product {
	@Id
	@Column(name = "product_code")
	private String code;
	
	@Column(name = "product_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "product_line_id")
	private ProductLine productline;
	
	@Column(name = "product_scale")
	private String scale;
	
	@Column(name = "product_vendor")
	private String vendor;
	
	@Column(name = "product_description")
	private String description;
	
	@Column(name = "quantity_in_stock")
	private Integer stock;
	
	@Column(name = "buy_price")
	private BigDecimal buyprice;
	
	@Column
	private BigDecimal MSRP;
}
