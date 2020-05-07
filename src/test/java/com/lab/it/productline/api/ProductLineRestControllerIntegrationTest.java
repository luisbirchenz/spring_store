package com.lab.it.productline.api;

import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.DBUnitExtension;
import com.lab.productline.dto.ProductLineDTO;
import com.lab.service.ProductLineService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.sql.DataSource;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.util.AssertionErrors.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith({DBUnitExtension.class, SpringExtension.class})
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class ProductLineRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductLineService productLineService;

    @Autowired
    private DataSource dataSource;

    public ConnectionHolder getConnectionHolder() {
        return () -> dataSource.getConnection();
    }

    @Test
    @DisplayName("findById /api/productline/{id} Success")
    @DataSet("productlines.xml")
    void findByIdSuccess() throws Exception{
        Optional<ProductLineDTO> productLineDTO = productLineService.findById(1L);
        if(!productLineDTO.isPresent()) {
            fail("Product not found");
        }
        System.out.println("hola");
        mockMvc.perform(get("/api/productline/{id}", 1L))
                // Validate response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // Validate headers
                .andExpect(header().string(HttpHeaders.ETAG, "\"Classic Cars\""))
                .andExpect(header().string(HttpHeaders.LOCATION, "api/productline/1"))
                // Validate returned fields
                .andExpect(jsonPath("$.productline", is(productLineDTO.get().getProductline())))
                .andExpect(jsonPath("$.text", is(productLineDTO.get().getText())))
                .andExpect(jsonPath("$.html", is(productLineDTO.get().getHtml())))
                .andExpect(jsonPath("$.image", is(productLineDTO.get().getImage())));
    }

    @Test
    void saveProductLine() {
    }

    @Test
    void updateProductLine() {
    }

    @Test
    void deleteProductLine() {
    }

    @Test
    void findAll() {
    }
}