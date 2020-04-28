package com.lab.productline.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
	@DisplayName("GET /api/productline/{id} - Found")
	void testFindById() throws Exception {
		List<ProductDTO> products = new ArrayList<>();
		ProductDTO productDTO = new ProductDTO("S10_1949", "1952 Alpine Renault 1300", "Classic Cars", "1:10", "Classic Metal Creations", "description", 7, new BigDecimal(98.0), new BigDecimal(214.0));
		products.add(productDTO);
		Optional<ProductLineDTO> dto = Optional.of(new ProductLineDTO(1L, "Classic Cars", "Text", "description", "image", products));
		doReturn(dto).when(service).findById(1L);
		
		// Execute the get request
		mockMvc.perform(get("/api/productline/{id}", 1L))
			// Validate the response code and content type
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			// Validate headers
			.andExpect(header().string(HttpHeaders.ETAG, "\"Classic Cars\""))
			.andExpect(header().string(HttpHeaders.LOCATION, "api/productline/1"))
			// Validate data
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.productline", is("Classic Cars")))
			.andExpect(jsonPath("$.text", is("Text")))
			.andExpect(jsonPath("$.description", is("description")))
			.andExpect(jsonPath("$.image", is("image")));
	}

	@Test
	@DisplayName("GET /api/productline/{id} - Not Found")
	void testFindById_Failed() throws Exception {
		doReturn(Optional.empty()).when(service).findById(1L);
		
		// Execute the get request
		mockMvc.perform(get("/api/productline/{id}", 1L))
			.andExpect(status().isNotFound());
	}
	
	
	@Test
	@DisplayName("POST /api/productline - SUCCESS")
	void saveProductLine() throws Exception {
		ProductLineDTO productDTO = new ProductLineDTO(null, "Sport Cars", "Text", "description", "image", Collections.emptyList());
		ProductLineDTO newProductDTO = new ProductLineDTO(1L, "Sport Cars", "Text", "description", "image", Collections.emptyList());
		doReturn(newProductDTO).when(service).save(any(ProductLineDTO.class));
		
		mockMvc.perform(
				post("/api/productline")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(productDTO)))
				// Validate the response code and content type 
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				// Validate headers
				.andExpect(header().string(HttpHeaders.ETAG, "\"Sport Cars\""))
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
	

	@Test
	@DisplayName("PUT /api/productline/{id} - SUCCESS")
	void updateProductLine() throws Exception {
		ProductLineDTO putProductDTO = new ProductLineDTO(null, "Executive Cars", "Text", "description", "image", Collections.emptyList());
		ProductLineDTO modifiedProductDTO = new ProductLineDTO(1L, "Executive Cars", "Text", "description", "image", Collections.emptyList());
		Optional<ProductLineDTO> currentDTO = Optional.of(new ProductLineDTO(1L, "Sport Cars", "Text", "description", "image", Collections.emptyList()));
		doReturn(currentDTO).when(service).findById(1L);
		doReturn(modifiedProductDTO).when(service).save(any(ProductLineDTO.class));
		
		mockMvc.perform(
				put("/api/productline/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.IF_MATCH, "Sport Cars")
				.content(asJsonString(putProductDTO)))
				// Validate the response code and content type 
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				// Validate headers
				.andExpect(header().string(HttpHeaders.ETAG, "\"Executive Cars\""))
				.andExpect(header().string(HttpHeaders.LOCATION, "api/productline/1"))
				// Validate data
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.productline", is(modifiedProductDTO.getProductline())))
				.andExpect(jsonPath("$.text", is(modifiedProductDTO.getText())))
				.andExpect(jsonPath("$.description", is(modifiedProductDTO.getDescription())))
				.andExpect(jsonPath("$.image", is(modifiedProductDTO.getImage())));
	}
	
	@Test
	@DisplayName("PUT /api/productline/{id} - FAILED")
	void updateProductLine_failed() throws Exception {
		ProductLineDTO putProductDTO = null;
		ProductLineDTO modifiedProductDTO = new ProductLineDTO(1L, "Executive Cars", "Text", "description", "image", Collections.emptyList());
		Optional<ProductLineDTO> currentDTO = Optional.of(new ProductLineDTO(1L, "Sport Cars", "Text", "description", "image", Collections.emptyList()));
		doReturn(currentDTO).when(service).findById(1L);
		doReturn(modifiedProductDTO).when(service).save(any(ProductLineDTO.class));
		
		mockMvc.perform(
				put("/api/productline/{id}",1)
				.contentType(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.IF_MATCH, "Sport Cars")
				.content(asJsonString(putProductDTO)))
		.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
	}
	
	@Test
	@DisplayName("PUT /api/productline/{id} - NOT FOUND")
	void updateProductLine_notFound() throws Exception {
		ProductLineDTO putProductDTO = new ProductLineDTO(null, "Executive Cars", "Text", "description", "image", Collections.emptyList());
		ProductLineDTO modifiedProductDTO = new ProductLineDTO(1L, "Executive Cars", "Text", "description", "image", Collections.emptyList());
		Optional<ProductLineDTO> currentDTO = Optional.of(new ProductLineDTO(1L, "Sport Cars", "Text", "description", "image", Collections.emptyList()));
		doReturn(currentDTO).when(service).findById(1L);
		doReturn(modifiedProductDTO).when(service).save(any(ProductLineDTO.class));
		
		mockMvc.perform(
				put("/api/productline/{id}", 2)
				.contentType(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.IF_MATCH, "Sport Cars")
				.content(asJsonString(putProductDTO)))
		.andExpect(status().is(HttpStatus.NOT_FOUND.value()));
	}


	@Test
	@DisplayName("DELETE /api/productline/{id} - SUCCESS")
	void deleteProductLine() throws Exception {
		Optional<ProductLineDTO> mockDTO = Optional.of(new ProductLineDTO(1L, "Sport Cars", "Text", "description", "image", Collections.emptyList()));
		doReturn(mockDTO).when(service).findById(1L);
		doReturn(true).when(service).delete(1L);
		
		mockMvc.perform(
				delete("/api/productline/{id}", 1))
				.andExpect(status().isOk());
	}

	@Test
	@DisplayName("DELETE /api/productline/{id} - NOT FOUND")
	void deleteProductLine_notfound() throws Exception {
		Optional<ProductLineDTO> mockDTO = Optional.of(new ProductLineDTO(1L, "Sport Cars", "Text", "description", "image", Collections.emptyList()));
		doReturn(mockDTO).when(service).findById(1L);
		doReturn(true).when(service).delete(1L);
		
		mockMvc.perform(
				delete("/api/productline/{id}", 2))
				.andExpect(status().isNotFound());
	}

	@Test
	@DisplayName("DELETE /api/productline/{id} - FAILED")
	void deleteProductLine_failed() throws Exception {
		Optional<ProductLineDTO> mockDTO = Optional.of(new ProductLineDTO(1L, "Sport Cars", "Text", "description", "image", Collections.emptyList()));
		doReturn(mockDTO).when(service).findById(1L);
		doReturn(false).when(service).delete(1L);
		
		mockMvc.perform(
				delete("/api/productline/{id}", 1))
				.andExpect(status().isInternalServerError());
	}
	
	
	/**
	 * It transform an object in a JSON string by using Jackson stuff.
	 * @param obj
	 * @return
	 * @throws JsonProcessingException
	 */
	private static String asJsonString(Object obj) throws JsonProcessingException {
		 return new ObjectMapper().writeValueAsString(obj);
	}

}
