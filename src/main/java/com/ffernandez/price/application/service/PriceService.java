package com.ffernandez.price.application.service;

import com.ffernandez.price.application.exception.NotFoundException;
import com.ffernandez.price.application.port.in.PriceCommand;
import com.ffernandez.price.application.port.in.PriceUseCase;
import com.ffernandez.price.application.port.out.PricePort;
import com.ffernandez.price.domain.TotalPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class PriceService implements PriceUseCase {
    private final PricePort pricePort;
    @Override
    public TotalPrice getPrice(PriceCommand priceCommand) {
        return pricePort.getPriceList(priceCommand.getProductId(), priceCommand.getBrandId())
                .stream()
                .filter(price -> priceCommand.getDate().isAfter(price.getStartDate()) && priceCommand.getDate().isBefore(price.getEndDate()))
                .max(Comparator.comparing(price -> price.getPriority().getValue()))
                .orElseThrow(() -> new NotFoundException("Price not found"));
    }
}
