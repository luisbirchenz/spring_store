package com.lab.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.lab.dto.builder.ProductDTOBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.lab.common.entity.builder.ProductLineBuilder;
import com.lab.domain.ProductLine;
import com.lab.productline.dto.ProductLineDTO;
import com.lab.repository.ProductLineRepository;

@ExtendWith(MockitoExtension.class)
class ProductLineServiceTest {

	@InjectMocks
	private ProductLineService productLineService;
	
	@Mock
	private ProductLineRepository productLineRepository;
	
	@Mock
	private ModelMapper modelMapper;
	
	private ProductLineDTO productLineDTO = new ProductLineDTO();
	private ProductLine productLineEntity = new ProductLine();

	@Test
	@DisplayName("Test findById Success")
	void testFindByIdSuccess() {
		//Setup the mock
		Optional<ProductLine> mockProductLine = Optional.of(ProductLineBuilder.builder().build());
		doReturn(mockProductLine).when(productLineRepository).findById(any(Long.class));
		doReturn(productLineDTO).when(modelMapper).map(any(), any());
		
		productLineDTO.setId(1L);
		productLineDTO.setProductline("Sport Cars");
		productLineDTO.setHtml("<h1>Header</h1>");
		productLineDTO.setText("text");
		productLineDTO.setImage("icon.png");
		
		//Execute the task
		Optional<ProductLineDTO> result = productLineService.findById(1L);
		
		//Assert response
		Assertions.assertTrue(result.isPresent(), "Product was not found");		
		Assertions.assertSame(result.get().getId(), mockProductLine.get().getId(), "Id must be the same");
		Assertions.assertSame(result.get().getProductline(), mockProductLine.get().getProductline(), "Productline must be the same");
		Assertions.assertSame(result.get().getHtml(), mockProductLine.get().getHtml(), "Html description must be the same");
		Assertions.assertSame(result.get().getText(), mockProductLine.get().getText(), "Text must be the same");
		Assertions.assertSame(result.get().getImage(), mockProductLine.get().getImage(), "Image must be the same");
	}

	@Test
	@DisplayName("Test findById Failed")
	void testFindByIdFailed() {
		//Setup the mock
		Optional<ProductLine> mockProductLine = Optional.of(ProductLineBuilder.builder().build());
		doReturn(mockProductLine).when(productLineRepository).findById(1L);
		doReturn(productLineDTO).when(modelMapper).map(any(), any());

		productLineDTO.setId(2L);
		productLineDTO.setProductline("Sport Cars");
		productLineDTO.setHtml("<h1>Header</h1>");
		productLineDTO.setText("text");
		productLineDTO.setImage("icon.png");

		//Execute the task
		Optional<ProductLineDTO> result = productLineService.findById(1L);

		//Assert response
		Assertions.assertFalse(result.get().getId() != productLineDTO.getId());
	}


	@Test
	@DisplayName("Test findAll Success")
	void testFindAllSuccess() {
		// Setup
		List<ProductLine> productLineList = Collections.unmodifiableList(Arrays.asList(
				ProductLineBuilder.builder().build(),
				ProductLineBuilder.builder().id(2L).build()));
		doReturn(productLineList).when(productLineRepository).findAll();
		doReturn(productLineDTO).when(modelMapper).map(any(), any());

		// Execute
		List<ProductLineDTO> list = productLineService.findAll();

		//Assert
		Assertions.assertEquals(2, list.size(), "findAll should return 2 productLine");
	}

	@Test
	@DisplayName("Test save Success")
	void testSaveSuccess() {
		// Setup
		doReturn(productLineEntity).when(modelMapper).map(productLineDTO, ProductLine.class);
		doReturn(productLineEntity).when(productLineRepository).save(productLineEntity);

		doReturn(productLineDTO).when(modelMapper).map(productLineEntity, ProductLineDTO.class);

		productLineDTO.setId(1L);
		productLineDTO.setProductline("Sport Cars");
		productLineDTO.setHtml("<h1>Header</h1>");
		productLineDTO.setText("text");
		productLineDTO.setImage("icon.png");
		productLineDTO.setProducts(Arrays.asList(ProductDTOBuilder.builder().build(),
				ProductDTOBuilder.builder().code("S10_1950").build()));

		// Execute
		ProductLineDTO rest = productLineService.save(productLineDTO);

		// Assert
		Assertions.assertEquals(rest.getId(), productLineDTO.getId());
	}
}
