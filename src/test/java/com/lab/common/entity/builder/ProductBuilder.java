package com.lab.common.entity.builder;

import java.math.BigDecimal;

import com.lab.domain.Product;
import com.lab.domain.ProductLine;

public class ProductBuilder {
	private String code = "S10_1678";
	private String name = "1969 Harley Davidson Ultimate Chopper";
	private ProductLine productline = null;
	private String scale = "1:10";
	private String vendor = "Min Lin Diecast";
	private String description = "This replica features working.";
	private Integer stock = 7933;
	private BigDecimal buyprice = new BigDecimal(48.81);
	private BigDecimal MSRP = new BigDecimal(95.70);
	
	private ProductBuilder() {}
	
	public static ProductBuilder builder() {
		return new ProductBuilder();
	}
	
	public Product build() {
		Product p = new Product();
		p.setCode(this.code);
		p.setName(this.name);
		p.setProductline(this.productline);
		p.setScale(this.scale);
		p.setVendor(this.vendor);
		p.setDescription(this.description);
		p.setStock(this.stock);
		p.setBuyprice(this.buyprice);
		p.setMSRP(this.MSRP);
		return p;
	}
	
	public ProductBuilder code(String code) {
		this.code = code;
		return this;
	}
	public ProductBuilder name(String name) {
		this.name = name;
		return this;
	}
	public ProductBuilder productline(ProductLine productline) {
		this.productline = productline;
		return this;
	}
	public ProductBuilder scale(String scale) {
		this.scale = scale;
		return this;
	}
	public ProductBuilder vendor(String vendor) {
		this.vendor = vendor;
		return this;
	}
	public ProductBuilder description(String description) {
		this.description = description;
		return this;
	}
	public ProductBuilder stock(Integer stock) {
		this.stock = stock;
		return this;
	}
	public ProductBuilder buyprice(BigDecimal buyprice) {
		this.buyprice = buyprice;
		return this;
	}
	public ProductBuilder MSRP(BigDecimal MSRP) {
		this.MSRP = MSRP;
		return this;
	}
}
