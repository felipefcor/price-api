package com.ffernandez.price.adapter.in.rest.mother;

import com.ffernandez.price.adapter.in.rest.models.dto.PriceResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class PriceResponseMother {

    public static PriceResponse priceResponseWithSpecificData() {
        return new PriceResponse()
                .productId(35455L)
                .brandId(1L)
                .rate(1.0)
                .startDate(LocalDateTime.parse("2020-06-14T10:00:00.00"))
                .endDate(LocalDateTime.parse("2020-06-15T10:00:00.00"))
                .price(35.50);
    }
}
