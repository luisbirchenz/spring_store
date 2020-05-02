package com.lab.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.domain.ProductLine;
import com.lab.productline.dto.ProductLineDTO;
import com.lab.repository.ProductLineRepository;

@Service
public class ProductLineService {
	
	private final ProductLineRepository productLineRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public ProductLineService(ProductLineRepository productLineRepository, ModelMapper modelMapper) {
		this.productLineRepository = productLineRepository;
		this.modelMapper = modelMapper;
	}
	
	public Optional<ProductLineDTO> findById(Long id) {
		Optional<ProductLine> product = productLineRepository.findById(id);
		return product.map(this::toProductLineDTO);
	}
	
	public List<ProductLineDTO> findAll() {
		List<ProductLine> products = productLineRepository.findAll();
		return products		
				.stream()
				.map(this::toProductLineDTO)
				.collect(Collectors.toList());
	}
	
	public ProductLineDTO save(ProductLineDTO productLineDTO) {
		ProductLine productLine = productLineRepository.save(toProductLineEntity(productLineDTO));
		return toProductLineDTO(productLine);
	}
	
	public boolean delete(Long id) {
		productLineRepository.deleteById(id);
		return true;
	}

	
	public ProductLineDTO toProductLineDTO(ProductLine productline) {
		return modelMapper.map(productline, ProductLineDTO.class);
	}
	
	private ProductLine toProductLineEntity(ProductLineDTO productLineDTO) {
		return modelMapper.map(productLineDTO, ProductLine.class);
	}
}
