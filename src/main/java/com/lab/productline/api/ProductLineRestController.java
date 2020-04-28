package com.lab.productline.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.productline.dto.ProductLineDTO;
import com.lab.service.ProductLineService;

import lombok.experimental.PackagePrivate;

import static java.util.Objects.requireNonNull;
@RestController
@RequestMapping("api")
public class ProductLineRestController {
	
	private final ProductLineService service;
	
	public ProductLineRestController(ProductLineService service) {
		this.service = requireNonNull(service);
	}
	
	@GetMapping("/productline/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		requireNonNull(id);
		return service.findById(id).map(
				dto -> {					
					try {
						return ResponseEntity
								.ok()
								.eTag(dto.getProductline())
								.location(new URI("api/productline/" + dto.getId()))
								.body(dto);
					} catch(URISyntaxException e) {
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
					}
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/productline")
	public ResponseEntity<ProductLineDTO> saveProductLine(@RequestBody ProductLineDTO productLine) {
		requireNonNull(productLine);
		ProductLineDTO productLineDTO = service.save(productLine);
		
		try {
			return ResponseEntity
					.created(new URI("api/productline/"+productLineDTO.getId()))
					.eTag(productLineDTO.getProductline())
					.body(productLineDTO);
		} catch (URISyntaxException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@PutMapping("/productline/{id}")
	public ResponseEntity<?> updateProductLine(
			@PathVariable("id") Long id,
			@RequestBody ProductLineDTO productLineDTO,
			@RequestHeader("If-Match") String ifMatch) {
		
		requireNonNull(id);
		requireNonNull(productLineDTO);
		requireNonNull(ifMatch);
		
		//First of all find the product
		Optional<ProductLineDTO> currentProductLine = service.findById(id);
		
		return currentProductLine.map(
				p -> {
					if(!p.getProductline().equals(ifMatch)) {
						return ResponseEntity.status(HttpStatus.CONFLICT).build();
					}
					p.setDescription(productLineDTO.getDescription());
					p.setText(productLineDTO.getText());
					p.setImage(productLineDTO.getImage());
					p.setProductline(productLineDTO.getProductline());
				try {
					service.save(p);
					return ResponseEntity
							.ok()
							.location(new URI("api/productline/"+p.getId()))
							.eTag(p.getProductline())
							.body(p);
				} catch (URISyntaxException e) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
			}).orElse(ResponseEntity.notFound().build());
	}
		
	@DeleteMapping("/productline/{id}")
	public ResponseEntity<?> deleteProductLine(@PathVariable("id") Long id){
		//First of all find the product
		Optional<ProductLineDTO> currentProductLine = service.findById(id);
		
		return currentProductLine.map(
				p -> {
					if(service.delete(id)) {
						return ResponseEntity.ok().build();
					} else {
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
					}
				}).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/productline")
	public List<ProductLineDTO> findAll() {
		return service.findAll();
	}
	
	

}
