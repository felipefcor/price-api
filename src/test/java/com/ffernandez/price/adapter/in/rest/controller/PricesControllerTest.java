package com.ffernandez.price.adapter.in.rest.controller;

import com.ffernandez.price.adapter.in.rest.config.TestConfig;
import com.ffernandez.price.domain.BrandId;
import com.ffernandez.price.domain.ProductId;
import com.ffernandez.price.adapter.in.rest.mapper.out.PriceResponseMapper;
import com.ffernandez.price.application.port.in.PriceCommand;
import com.ffernandez.price.application.port.in.PriceUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {PricesController.class, TestConfig.class})
@AutoConfigureMockMvc
class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PricesController pricesController;

    @Autowired
    private PriceResponseMapper priceResponseMapper;
    @MockBean
    private PriceUseCase priceUseCase;

    @BeforeEach
    void init() {
        mockMvc =
                MockMvcBuilders.standaloneSetup(pricesController)
                        .build();
    }

    @ParameterizedTest
    @CsvSource({
            "35455, 1, 2020-06-14T10:00:00.00",
            "35455, 1, 2020-06-14T16:00:00.00",
            "35455, 1, 2020-06-14T21:00:00.00",
            "35455, 1, 2020-06-15T10:00:00.00",
            "35455, 1, 2020-06-16T21:00:00.00"
    })
    void getPricesWithProductIdAndBrandAndSpecificDateShouldSendCommandToUseCase(Long productId, Long brandId, LocalDateTime date) throws Exception {
        mockMvc.perform(get("/prices")
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .param("date", date.toString())
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk());

        then(priceUseCase).should()
                .getPrice(eq(PriceCommand.builder()
                        .productId(new ProductId(productId))
                        .brandId(new BrandId(brandId))
                        .date(date)
                        .build()));

    }

}