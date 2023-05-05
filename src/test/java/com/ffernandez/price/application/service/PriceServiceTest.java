package com.ffernandez.price.application.service;


import com.ffernandez.price.adapter.in.rest.mother.PriceCommandMother;
import com.ffernandez.price.application.exception.NotFoundException;
import com.ffernandez.price.application.port.in.PriceCommand;
import com.ffernandez.price.application.port.out.PricePort;
import com.ffernandez.price.domain.BrandId;
import com.ffernandez.price.domain.ProductId;
import com.ffernandez.price.domain.mother.TotalPriceMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @Mock
    private PricePort pricePort;

    @InjectMocks
    private PriceService priceService;

    @Test
    @DisplayName("Test 1: request at 10 am of 14th with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_14_10am_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-14T10:00:00.00"));
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200614And20201231AndPriority0();

        given(pricePort.getPriceList(priceCommand.getProductId(), priceCommand.getBrandId()))
                .willReturn(List.of(expectedTotalPrice));

        final var actualTotalPrice = priceService.getPrice(priceCommand);
        then(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }

    @Test
    @DisplayName("Test 2: request at 16 pm of 14th of 2020 with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_14_16pm_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-14T16:00:00.00"));
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200614And20200614AndPriority1();

        given(pricePort.getPriceList(priceCommand.getProductId(), priceCommand.getBrandId()))
                .willReturn(List.of(expectedTotalPrice, TotalPriceMother.priceWithAllDataAndDatesBetween20200614And20200614AndPriority1()));

        final var actualTotalPrice = priceService.getPrice(priceCommand);
        then(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }

    @Test
    @DisplayName("Test 3: request at 9 pm of 14th of 2020 with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_14_21pm_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-14T21:00:00.00"));
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200614And20201231AndPriority0();

        given(pricePort.getPriceList(priceCommand.getProductId(), priceCommand.getBrandId()))
                .willReturn(List.of(expectedTotalPrice));

        final var actualTotalPrice = priceService.getPrice(priceCommand);
        then(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }

    @Test
    @DisplayName("Test 4: request at 10 am of 15th of 2020 with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_15_10_am_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-15T10:00:00.00"));
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200615And20200615AndPriority1();

        given(pricePort.getPriceList(priceCommand.getProductId(), priceCommand.getBrandId()))
                .willReturn(List.of(expectedTotalPrice));

        final var actualTotalPrice = priceService.getPrice(priceCommand);
        then(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }

    @Test
    @DisplayName("Test 5: request at 9pm of 16th of 2020 with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_16_21pm_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-16T21:00:00.00"));
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200615And20201231AndPriority1();

        given(pricePort.getPriceList(priceCommand.getProductId(), priceCommand.getBrandId()))
                .willReturn(List.of(expectedTotalPrice));

        final var actualTotalPrice = priceService.getPrice(priceCommand);
        then(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }

    @Test
    @DisplayName("Test 6: request at 9pm of 16th of 2020 with product 1000 for the brand 1")
    void getPriceWithPriceCommandThrowAnErrorWhenProductIdNotFound() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-16T21:00:00.00"));
        priceCommand.toBuilder().productId(new ProductId(1000L));

        given(pricePort.getPriceList(priceCommand.getProductId(), priceCommand.getBrandId()))
                .willReturn(List.of());

        Exception exception = Assertions.assertThrows(NotFoundException.class, () -> priceService.getPrice(priceCommand));
        Assertions.assertEquals("Price not found", exception.getMessage());
    }

    @Test
    @DisplayName("Test 7: request at 9pm of 16th of 2020 with product 35455 for the brand 2")
    void getPriceWithPriceCommandThrowAnErrorWhenBrandIdNotFound() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-16T21:00:00.00"));
        priceCommand.toBuilder().brandId(new BrandId(2L));

        given(pricePort.getPriceList(priceCommand.getProductId(), priceCommand.getBrandId()))
                .willReturn(List.of());

        Exception exception = Assertions.assertThrows(NotFoundException.class, () -> priceService.getPrice(priceCommand));
        Assertions.assertEquals("Price not found", exception.getMessage());
    }

    @Test
    @DisplayName("Test 8: request at 9pm of 16th of 2022 with product 35455 for the brand 1")
    void getPriceWithPriceCommandThrowAnErrorWhenDataNotExistsInDatabase() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2022-06-16T21:00:00.00"));

        given(pricePort.getPriceList(priceCommand.getProductId(), priceCommand.getBrandId()))
                .willReturn(List.of());

        Exception exception = Assertions.assertThrows(NotFoundException.class, () -> priceService.getPrice(priceCommand));
        Assertions.assertEquals("Price not found", exception.getMessage());
    }
}