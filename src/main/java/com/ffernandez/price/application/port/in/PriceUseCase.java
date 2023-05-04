package com.ffernandez.price.application.port.in;

import com.ffernandez.price.domain.TotalPrice;

public interface PriceUseCase {
    TotalPrice getPrice(PriceCommand priceCommand);
}
