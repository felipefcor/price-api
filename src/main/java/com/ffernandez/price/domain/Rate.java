package com.ffernandez.price.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Rate {
    @NotEmpty(message = "Rate it cannot be empty")
    Double rate;
}
