package com.ffernandez.price.domain.mother;

import com.ffernandez.price.domain.*;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class TotalPriceMother {
    public TotalPrice totalPriceWithSpecificData() {
        return TotalPrice.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .rate(new Rate(1.0))
                .startDate(LocalDateTime.parse("2020-06-14T10:00:00.00"))
                .endDate(LocalDateTime.parse("2020-06-15T10:00:00.00"))
                .price(new Price(35.50))
                .build();
    }

    public TotalPrice priceWithAllData() {
        return TotalPrice.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .rate(new Rate(1.0))
                .startDate(LocalDateTime.parse("2020-06-14T10:00:00.00"))
                .endDate(LocalDateTime.parse("2020-06-15T10:00:00.00"))
                .price(new Price(35.50))
                .priority(new Priority(1))
                .currency(new Currency("EUR"))
                .build();
    }

    public TotalPrice priceWithAllDataAndDatesBetween20200614And20201231AndPriority0() {
        return TotalPrice.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .rate(new Rate(1.0))
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00.00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59.00"))
                .price(new Price(35.50))
                .priority(new Priority(0))
                .currency(new Currency("EUR"))
                .build();
    }

    public TotalPrice priceWithAllDataAndDatesBetween20200614And20200614AndPriority1() {
        return TotalPrice.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .rate(new Rate(1.0))
                .startDate(LocalDateTime.parse("2020-06-14T15:00:00.00"))
                .endDate(LocalDateTime.parse("2020-06-14T18:30:00.00"))
                .price(new Price(35.50))
                .priority(new Priority(1))
                .currency(new Currency("EUR"))
                .build();
    }

    public TotalPrice priceWithAllDataAndDatesBetween20200615And20200615AndPriority1() {
        return TotalPrice.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .rate(new Rate(1.0))
                .startDate(LocalDateTime.parse("2020-06-15T00:00:00.00"))
                .endDate(LocalDateTime.parse("2020-06-15T11:00:00.00"))
                .price(new Price(35.50))
                .priority(new Priority(1))
                .currency(new Currency("EUR"))
                .build();
    }

    public TotalPrice priceWithAllDataAndDatesBetween20200615And20201231AndPriority1() {
        return TotalPrice.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .rate(new Rate(1.0))
                .startDate(LocalDateTime.parse("2020-06-15T16:00:00.00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59.00"))
                .price(new Price(35.50))
                .priority(new Priority(1))
                .currency(new Currency("EUR"))
                .build();
    }
}
