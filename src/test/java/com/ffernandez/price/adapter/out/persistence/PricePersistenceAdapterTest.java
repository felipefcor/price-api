package com.ffernandez.price.adapter.out.persistence;

import com.ffernandez.price.adapter.out.persistence.config.TestConfig;
import com.ffernandez.price.adapter.out.persistence.mapper.PriceMapper;
import com.ffernandez.price.domain.BrandId;
import com.ffernandez.price.domain.ProductId;
import com.ffernandez.price.domain.TotalPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(excludeAutoConfiguration =  FlywayAutoConfiguration.class)
@Import({TestConfig.class})
class PricePersistenceAdapterTest {
    @Autowired
    private PricePersistenceAdapter pricePersistenceAdapter;

    @Autowired
    private SpringDataPriceRepository springDataPriceRepository;

    @Autowired
    private PriceMapper priceMapper;

    @Test
    @Sql("/migration/V998__create_table_prices.sql")
    @Sql("/migration/V999__insert_data_table_prices.sql")
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