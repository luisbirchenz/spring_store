package com.lab.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * This entity manages products, by storing a list of scale model cars.
 * @author luis
 */
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
	
	Product() {
		// Used by JPA
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductLine getProductline() {
		return productline;
	}

	public void setProductline(ProductLine productline) {
		this.productline = productline;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getBuyprice() {
		return buyprice;
	}

	public void setBuyprice(BigDecimal buyprice) {
		this.buyprice = buyprice;
	}

	public BigDecimal getMSRP() {
		return MSRP;
	}

	public void setMSRP(BigDecimal mSRP) {
		MSRP = mSRP;
	}

	
}
