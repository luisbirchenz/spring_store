package com.lab.order.dto;

import java.time.LocalDate;
import java.util.List;

import com.lab.customer.dto.CustomerDTO;
import com.lab.orderdetail.dto.OrderDetailDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private Long id;
	private LocalDate orderDate;
	private LocalDate requiredDate;
	private LocalDate shippedDate;
	private String status;
	private String comments;
	private CustomerDTO customer;
	private List<OrderDetailDTO> details;
}
