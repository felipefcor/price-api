package com.ffernandez.price.adapter.in.rest.mother;

import com.ffernandez.price.application.port.in.PriceCommand;
import com.ffernandez.price.domain.BrandId;
import com.ffernandez.price.domain.ProductId;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class PriceCommandMother {

    public PriceCommand priceCommandWithSpecificDate(LocalDateTime date) {
        return PriceCommand.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .date(date)
                .build();
    }

}
