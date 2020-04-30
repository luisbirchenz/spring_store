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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
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
	
	@OneToMany(mappedBy = "productline", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Product> products;
}
