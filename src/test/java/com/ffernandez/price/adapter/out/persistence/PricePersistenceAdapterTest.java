package com.ffernandez.price.adapter.out.persistence;

import com.ffernandez.price.adapter.out.persistence.config.TestConfig;
import com.ffernandez.price.adapter.out.persistence.mapper.PriceMapper;
import com.ffernandez.price.domain.BrandId;
import com.ffernandez.price.domain.ProductId;
import com.ffernandez.price.domain.TotalPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({TestConfig.class})
class PricePersistenceAdapterTest {
    @Autowired
    private PricePersistenceAdapter pricePersistenceAdapter;

    @Autowired
    private SpringDataPriceRepository springDataPriceRepository;

    @Autowired
    private PriceMapper priceMapper;

    @Test
    void getPriceByProductIdAndBrandId() {
        Long productId = 35455L;
        Long brandId = 1L;

        List<TotalPrice> totalPrice = pricePersistenceAdapter.getPriceList(new ProductId(productId), new BrandId(brandId));

        assertThat(totalPrice).hasSize(4);
        assertThat(totalPrice.get(0).getBrandId().getId()).isEqualTo(brandId);
        assertThat(totalPrice.get(0).getProductId().getId()).isEqualTo(productId);
        assertThat(totalPrice.get(1).getBrandId().getId()).isEqualTo(brandId);
        assertThat(totalPrice.get(1).getProductId().getId()).isEqualTo(productId);
        assertThat(totalPrice.get(2).getBrandId().getId()).isEqualTo(brandId);
        assertThat(totalPrice.get(2).getProductId().getId()).isEqualTo(productId);
        assertThat(totalPrice.get(3).getBrandId().getId()).isEqualTo(brandId);
        assertThat(totalPrice.get(3).getProductId().getId()).isEqualTo(productId);
    }
}