package com.ffernandez.price.application.port.out;

import com.ffernandez.price.domain.BrandId;
import com.ffernandez.price.domain.ProductId;
import com.ffernandez.price.domain.TotalPrice;

import java.util.List;

public interface PricePort {
    List<TotalPrice> getPriceList(ProductId productId, BrandId brandId);
}
