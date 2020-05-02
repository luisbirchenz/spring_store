package com.lab.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

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
	

}
