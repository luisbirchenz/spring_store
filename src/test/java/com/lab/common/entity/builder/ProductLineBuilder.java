package com.lab.common.entity.builder;

import java.util.List;
import java.util.Arrays;
import com.lab.domain.Product;
import com.lab.domain.ProductLine;

public class ProductLineBuilder {
	private Long id = 1L;
	private String productline = "Sport Cars";
	private String text = "text";
	private String html = "<h1>Header</h1>";
	private String image = "icon.png";
	private List<Product> products = Arrays.asList(ProductBuilder.builder().build());
	
	private ProductLineBuilder() {}
	
	public static ProductLineBuilder builder() {
		return new ProductLineBuilder();
	}
	
	public ProductLine build() {
		ProductLine p = new ProductLine();
		p.setId(this.id);
		p.setProductline(this.productline);
		p.setText(this.text);
		p.setHtml(this.html);
		p.setImage(this.image);
		p.setProducts(this.products);
		return p;
	}
	
	public ProductLineBuilder id(Long id) {
		this.id = id;
		return this;
	}
	
	public ProductLineBuilder productline(String productline) {
		this.productline = productline;
		return this;
	}
	
	public ProductLineBuilder text(String text) {
		this.text = text;
		return this;
	}
	
	public ProductLineBuilder html(String html) {
		this.html = html;
		return this;
	}
	
	public ProductLineBuilder image(String image) {
		this.image = image;
		return this;
	}
	
	public ProductLineBuilder products(List<Product> products) {
		this.products = products;
		return this;
	}
}
