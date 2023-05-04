package com.ffernandez.price.adapter.in.rest.mapper.out;

import com.ffernandez.price.adapter.in.rest.mother.PriceResponseMother;
import com.ffernandez.price.domain.mother.TotalPriceMother;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class PriceResponseMapperTest {

    PriceResponseMapper priceResponseMapper = new PriceResponseMapperImpl();

    @Test
    void domainToApi() {
        final var totalPrice = TotalPriceMother.totalPriceWithAllData();

        final var actualPriceResponse = priceResponseMapper.domainToApi(totalPrice);

        final var expectedPriceResponse = PriceResponseMother.priceResponseWithAllData();
        then(actualPriceResponse).isEqualTo(expectedPriceResponse);
    }
}