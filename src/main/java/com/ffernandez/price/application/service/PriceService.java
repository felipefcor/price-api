package com.ffernandez.price.application.service;

import com.ffernandez.price.application.port.in.PriceCommand;
import com.ffernandez.price.application.port.in.PriceUseCase;
import com.ffernandez.price.domain.TotalPrice;
import org.springframework.stereotype.Service;

@Service
public class PriceService implements PriceUseCase {
    @Override
    public TotalPrice getPrice(PriceCommand priceCommand) {
        return null;
    }
}
