package com.lab.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
@Entity(name = "orderdetails")
public class OrderDetail {

	@EmbeddedId
	private OrderDetailId id;

	@Column(name = "quantity_ordered")
	private int quantity;

	@Column(name = "price_each")
	private BigDecimal price;

	@Column(name = "order_line_number")
	private int orderLineNbr;

	@ManyToOne
	@JoinColumn(name = "product_code", insertable = false, updatable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "order_number", insertable = false, updatable = false)
	private Order order;	

}
