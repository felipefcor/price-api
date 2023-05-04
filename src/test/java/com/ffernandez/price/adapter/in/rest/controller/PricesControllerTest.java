package com.ffernandez.price.adapter.in.rest.controller;

import com.ffernandez.price.adapter.in.rest.mapper.out.PriceResponseMapper;
import com.ffernandez.price.application.port.in.PriceCommand;
import com.ffernandez.price.application.port.in.PriceUseCase;
import com.ffernandez.price.domain.BrandId;
import com.ffernandez.price.domain.ProductId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atMost;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PricesController.class)
class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceResponseMapper priceResponseMapper;
    @MockBean
    private PriceUseCase priceUseCase;

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

    @Test
    void getPricesWithProductIdAndBrandAndBadDateThrowAnError() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", LocalDate.now().toString())
                        .header("Content-Type", "application/json"))
                .andExpect(status().isBadRequest());

        then(priceUseCase).should(atMost(0))
                .getPrice(eq(PriceCommand.builder()
                        .productId(new ProductId(35455L))
                        .brandId(new BrandId(1L))
                        .date(LocalDateTime.now())
                        .build()));
    }

    @Test
    void getPricesWithBadProductIdAndBrandAndDateThrowAnError() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("productId", "string")
                        .param("brandId", "1")
                        .param("date", "2020-06-14T10:00:00.00")
                        .header("Content-Type", "application/json"))
                .andExpect(status().isBadRequest());

        then(priceUseCase).should(atMost(0))
                .getPrice(eq(PriceCommand.builder()
                        .productId(new ProductId(35455L))
                        .brandId(new BrandId(1L))
                        .date(LocalDateTime.parse("2020-06-14T10:00:00.00"))
                        .build()));
    }

    @Test
    void getPricesWithProductIdAndBadBrandAndDateThrowAnError() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("productId", "35455")
                        .param("brandId", "string")
                        .param("date", "2020-06-14T10:00:00.00")
                        .header("Content-Type", "application/json"))
                .andExpect(status().isBadRequest());

        then(priceUseCase).should(atMost(0))
                .getPrice(eq(PriceCommand.builder()
                        .productId(new ProductId(35455L))
                        .brandId(new BrandId(1L))
                        .date(LocalDateTime.parse("2020-06-14T10:00:00.00"))
                        .build()));
    }

}