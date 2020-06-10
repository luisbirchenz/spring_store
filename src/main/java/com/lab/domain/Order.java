package com.lab.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
@Entity(name = "orders")
public class Order {
	
	@Id
	@Column(name = "order_number")
	private Long id;
	
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	@Column(name = "required_date")
	private LocalDate requiredDate;
	
	@Column(name = "shipped_date")
	private LocalDate shippedDate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "comments")
	private String comments;

	@ManyToOne
	@JoinColumn(name = "customer_number", insertable = false, updatable = false)	
	private Customer customer;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<OrderDetail> details;
	
}
