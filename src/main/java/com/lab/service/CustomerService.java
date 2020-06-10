package com.lab.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lab.common.AbstractBiConverter;
import com.lab.customer.dto.CustomerDTO;
import com.lab.domain.Customer;
import com.lab.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService extends AbstractBiConverter<Customer, CustomerDTO>{

	private final CustomerRepository customerRepository;
	
	public Optional<CustomerDTO> findById(Long id) {
		return customerRepository.findById(id).map(this::toDto);
	}

	@Override
	public CustomerDTO toDto(Customer entity) {
		return modelMapper.map(entity, CustomerDTO.class);
	}

	@Override
	public Customer toEntity(CustomerDTO dto) {
		return modelMapper.map(dto, Customer.class);
	}
	
}
