package com.lab.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.DestinationSetter;
import org.springframework.stereotype.Service;

import com.lab.domain.Order;
import com.lab.domain.OrderDetail;
import com.lab.order.dto.OrderDTO;
import com.lab.orderdetail.dto.OrderDetailDTO;
import com.lab.repository.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	private ModelMapper converter;
	
	public OrderService(OrderRepository orderRepository, ModelMapper converter) {
		this.orderRepository = orderRepository;
		this.converter = converter;
	}
	
	public List<OrderDTO> findAll() {
		return orderRepository.findAll()
				.stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	public Optional<OrderDTO> findById(Long id) {
		return orderRepository.findById(id).map(this::toDTO);
	}
	
	private OrderDTO toDTO(Order order) {
		return converter.map(order, OrderDTO.class);
	}
	
	private Order toOrderEntity(OrderDTO orderDTO) {
		return converter.map(orderDTO, Order.class);
	}
}
