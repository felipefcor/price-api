package com.ffernandez.price.adapter.out.persistence.mother;

import com.ffernandez.price.adapter.out.persistence.PriceJpaEntity;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class PriceJpaMother {
    public PriceJpaEntity priceWithAllData() {
        final var priceJpaEntity = new PriceJpaEntity();
        priceJpaEntity.setBrandId(1L);
        priceJpaEntity.setProductId(35455L);
        priceJpaEntity.setRate(1.0);
        priceJpaEntity.setStartDate(LocalDateTime.parse("2020-06-14T10:00:00.00"));
        priceJpaEntity.setEndDate(LocalDateTime.parse("2020-06-15T10:00:00.00"));
        priceJpaEntity.setPrice(35.50);
        priceJpaEntity.setPriority(1);
        priceJpaEntity.setCurrency("EUR");
        return priceJpaEntity;
    }
}
