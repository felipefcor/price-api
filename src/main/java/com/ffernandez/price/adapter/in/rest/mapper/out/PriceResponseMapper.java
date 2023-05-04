package com.ffernandez.price.adapter.in.rest.mapper.out;

import com.ffernandez.price.adapter.in.rest.models.dto.PriceResponse;
import com.ffernandez.price.domain.TotalPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceResponseMapper {

  @Mapping(target = "productId", source = "productId.id")
  @Mapping(target = "brandId", source = "brandId.id")
  @Mapping(target = "rate", source = "rate.rate")
  @Mapping(target = "date", source = "date")
  @Mapping(target = "price", source = "price.price")
  PriceResponse domainToApi(TotalPrice totalPrice);
}
