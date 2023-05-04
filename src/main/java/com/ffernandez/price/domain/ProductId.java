package com.ffernandez.price.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ProductId {
    @NotEmpty(message = "Id it cannot be empty")
    Long id;
}
