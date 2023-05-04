package com.ffernandez.price.adapter.out.persistence;

import com.ffernandez.price.adapter.out.persistence.mapper.PriceMapper;
import com.ffernandez.price.adapter.out.persistence.mapper.PriceMapperImpl;
import com.ffernandez.price.adapter.out.persistence.mother.PriceJpaMother;
import com.ffernandez.price.domain.mother.TotalPriceMother;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class PriceMapperTest {

    PriceMapper priceMapper = new PriceMapperImpl();

    @Test
    void persistenceToDomain() {
        final var priceJpaEntity = PriceJpaMother.priceWithAllData();

        final var actualTotalPriceResponse = priceMapper.persistenceToDomain(priceJpaEntity);

        final var expectedTotalPrice = TotalPriceMother.priceWithAllData();
        then(actualTotalPriceResponse).isEqualTo(expectedTotalPrice);
    }
}