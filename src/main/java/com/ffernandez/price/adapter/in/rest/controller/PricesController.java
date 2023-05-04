package com.ffernandez.price.adapter.in.rest.controller;

import com.ffernandez.price.adapter.in.rest.mapper.out.PriceResponseMapper;
import com.ffernandez.price.adapter.in.rest.models.api.PricesApi;
import com.ffernandez.price.adapter.in.rest.models.dto.PriceResponse;
import com.ffernandez.price.application.port.in.PriceCommand;
import com.ffernandez.price.application.port.in.PriceUseCase;
import com.ffernandez.price.domain.BrandId;
import com.ffernandez.price.domain.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class PricesController implements PricesApi {

    private final PriceUseCase priceUseCase;
    private final PriceResponseMapper priceResponseMapper;

    @Override
    public ResponseEntity<PriceResponse> price(Long productId, Long brandId, LocalDateTime date) {
        final var priceCommand= PriceCommand.builder()
                .productId(new ProductId(productId))
                .brandId(new BrandId(brandId))
                .date(date)
                .build();

        final var totalPrice = priceUseCase.getPrice(priceCommand);

        final var pricesResponse= priceResponseMapper.domainToApi(totalPrice);

        return ResponseEntity.ok(pricesResponse);
    }
}
