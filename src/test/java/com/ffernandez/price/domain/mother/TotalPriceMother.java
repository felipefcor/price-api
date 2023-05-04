package com.ffernandez.price.domain.mother;

import com.ffernandez.price.domain.*;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class TotalPriceMother {
    public TotalPrice totalPriceWithAllData() {
        return TotalPrice.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .rate(new Rate(1.0))
                .date(LocalDateTime.parse("2020-06-14T10:00:00.00"))
                .price(new Price(35.50))
                .build();
    }
}
