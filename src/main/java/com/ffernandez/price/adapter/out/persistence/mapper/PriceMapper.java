package com.ffernandez.price.adapter.out.persistence.mapper;

import com.ffernandez.price.adapter.out.persistence.PriceJpaEntity;
import com.ffernandez.price.domain.TotalPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface PriceMapper {

    @Mapping(target = "productId.id", source = "productId")
    @Mapping(target = "brandId.id", source = "brandId")
    @Mapping(target = "rate.rate", source = "rate")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "price.price", source = "price")
    @Mapping(target = "priority.value", source = "priority")
    @Mapping(target = "currency.isoCurr", source = "currency")
    TotalPrice persistenceToDomain(PriceJpaEntity priceJpaEntity);
}