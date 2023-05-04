package com.ffernandez.price.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Price {
    @NotEmpty(message = "Price it cannot be empty")
    Double price;
}
