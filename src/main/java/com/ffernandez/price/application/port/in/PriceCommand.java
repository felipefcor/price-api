package com.ffernandez.price.application.port.in;

import com.ffernandez.price.domain.BrandId;
import com.ffernandez.price.domain.ProductId;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder(toBuilder = true)
public class PriceCommand {
    @NonNull ProductId productId;

    @NonNull BrandId brandId;

    @NonNull LocalDateTime date;

}
