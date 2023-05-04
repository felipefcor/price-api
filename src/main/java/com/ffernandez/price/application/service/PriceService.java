package com.ffernandez.price.application.service;

import com.ffernandez.price.application.port.in.PriceCommand;
import com.ffernandez.price.application.port.in.PriceUseCase;
import com.ffernandez.price.application.port.out.PricePort;
import com.ffernandez.price.domain.TotalPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceService implements PriceUseCase {
    private final PricePort pricePort;
    @Override
    public TotalPrice getPrice(PriceCommand priceCommand) {
        return null;
    }
}
