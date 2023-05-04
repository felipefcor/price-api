package com.ffernandez.price.adapter.in.rest.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDTO {

    private final ZonedDateTime timestamp;
    private final String status;
    private final UUID logRef;
    private final String path;
    private final String exception;
    private final String message;
}
