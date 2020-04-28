package com.lab.productline.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.product.dto.ProductDTO;
import com.lab.productline.dto.ProductLineDTO;
import com.lab.service.ProductLineService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductLineRestControllerTest {

	@MockBean
	private ProductLineService service;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("GET /api/productline/1 - Found")
	void testFindById() throws Exception {
		List<ProductDTO> products = new ArrayList<>();
		ProductDTO productDTO = new ProductDTO("S10_1949", "1952 Alpine Renault 1300", "Classic Cars", "1:10", "Classic Metal Creations", "description", 7, new BigDecimal(98.0), new BigDecimal(214.0));
		products.add(productDTO);
		Optional<ProductLineDTO> dto = Optional.of(new ProductLineDTO(1L, "Classic Cars", "Text", "description", "image", products, 1L));
		doReturn(dto).when(service).findById(1L);
		
		// Execute the get request
		mockMvc.perform(get("/api/productline/{id}", 1L))
			// Validate the response code and content type
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			// Validate headers
			.andExpect(header().string(HttpHeaders.ETAG, "\"1\""))
			.andExpect(header().string(HttpHeaders.LOCATION, "api/productline/1"))
			// Validate data
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.productline", is("Classic Cars")))
			.andExpect(jsonPath("$.text", is("Text")))
			.andExpect(jsonPath("$.description", is("description")))
			.andExpect(jsonPath("$.image", is("image")));
	}

	@Test
	@DisplayName("GET /api/productline/1 - Not Found")
	void testFindById_Failed() throws Exception {
		doReturn(Optional.empty()).when(service).findById(1L);
		
		// Execute the get request
		mockMvc.perform(get("/api/productline/{id}", 1L))
			.andExpect(status().isNotFound());
	}
	
	
	@Test
	@DisplayName("POST /api/productline - SUCCESS")
	void saveProductLine() throws Exception {
		ProductLineDTO productDTO = new ProductLineDTO(null, "Sport Cars", "Text", "description", "image", Collections.emptyList(), 1L);
		ProductLineDTO newProductDTO = new ProductLineDTO(1L, "Sport Cars", "Text", "description", "image", Collections.emptyList(), 1L);
		doReturn(newProductDTO).when(service).save(any(ProductLineDTO.class));
		//String asJsonString = new ObjectMapper().writeValueAsString(productDTO);
		
		mockMvc.perform(
				post("/api/productline")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(productDTO)))
				// Validate the response code and content type 
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				// Validate headers
				.andExpect(header().string(HttpHeaders.ETAG, "\"1\""))
				.andExpect(header().string(HttpHeaders.LOCATION, "api/productline/1"))
				// Validate data
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.productline", is(productDTO.getProductline())))
				.andExpect(jsonPath("$.text", is(productDTO.getText())))
				.andExpect(jsonPath("$.description", is(productDTO.getDescription())))
				.andExpect(jsonPath("$.image", is(productDTO.getImage())));
	}
	
	@Test
	@DisplayName("POST /api/productline - FAILED")
	void saveProductLine_Failed() throws Exception {
		ProductLineDTO productDTO = null;
		doReturn(productDTO).when(service).save(any(ProductLineDTO.class));		
		// Execute the get request
		mockMvc.perform(post("/api/productline")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(productDTO)))
			.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
	}
	
	
	
	private static String asJsonString(Object obj) throws JsonProcessingException {
		 return new ObjectMapper().writeValueAsString(obj);
	}

}
