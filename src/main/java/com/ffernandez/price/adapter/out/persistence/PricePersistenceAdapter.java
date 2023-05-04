package com.ffernandez.price.adapter.out.persistence;

import com.ffernandez.price.adapter.out.persistence.mapper.PriceMapper;
import com.ffernandez.price.application.port.out.PricePort;
import com.ffernandez.price.domain.BrandId;
import com.ffernandez.price.domain.ProductId;
import com.ffernandez.price.domain.TotalPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PricePersistenceAdapter implements PricePort {
    private final SpringDataPriceRepository springDataPriceRepository;
    private final PriceMapper priceMapper;

    @Override
    public List<TotalPrice> getPriceList(ProductId productId, BrandId brandId) {
        return springDataPriceRepository.findByProductIdAndBrandId(productId.getId(), brandId.getId())
                .stream()
                .map(priceMapper::persistenceToDomain)
                .toList();

    }
}
