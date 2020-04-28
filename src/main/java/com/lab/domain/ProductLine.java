package com.lab.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * This entity manages a list of product line categories.
 * @author luis
 */
@Entity(name = "productlines")
public class ProductLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_line_id")
	private Long id;
	
	@Column(name = "product_line")
	private String productline;
	
	@Column(name = "text_description")
	private String text;
	
	@Column(name = "html_description")
	private String html;
	
	@Column(name = "image")
	private String image;
	
//	@Column(name="version", nullable = false, columnDefinition = "int default 1") 
//	private Long version;
	
	@OneToMany(mappedBy = "productline", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Product> products;
	
	ProductLine() {
		// Used by JPA.
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductline() {
		return productline;
	}

	public void setProductline(String productline) {
		this.productline = productline;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

//	public Long getVersion() {
//		return version;
//	}
//
//	public void setVersion(Long version) {
//		this.version = version;
//	}
}
