package com.ffernandez.price.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder(toBuilder = true)
public class TotalPrice {
    @NotNull ProductId productId;

    @NotNull BrandId brandId;

    @NotNull Rate rate;

    @NotNull LocalDateTime startDate;

    @NotNull LocalDateTime endDate;

    @NotNull Price price;

    Priority priority;

    Currency currency;



}
