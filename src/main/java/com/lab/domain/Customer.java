package com.lab.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
@Entity(name = "customers")
public class Customer {
	
	@Id
	@Column(name = "customer_number")
	private Long customerNumber;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "contact_last_name")
	private String contactLastName;
	
	@Column(name = "contact_first_name")
	private String contactFirstName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address_line1")
	private String addressLine1;
	
	@Column(name = "address_line2")
	private String addressLine2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
		
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "country")
	private String country;	
	
	@Column(name = "credit_limit")
	private BigDecimal creditClimit;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Order> orders;
	
	/**
	 * EN LUGAR DE ESTE CAMPO TENEMOS QUE CONECTAR CON EL CAMBIO DE SIMON.
	 */
	//private Long sales_rep_employee_number;

}
