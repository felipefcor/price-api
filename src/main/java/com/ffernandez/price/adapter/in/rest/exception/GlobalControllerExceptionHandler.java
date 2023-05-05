package com.ffernandez.price.adapter.in.rest.exception;

import com.ffernandez.price.application.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleExceptionNotFound(RuntimeException exception, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorDTO errorDto =
                ErrorDTO.builder()
                        .timestamp(ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Z")))
                        .status(String.valueOf(HttpStatus.NOT_FOUND.value()))
                        .logRef(UUID.randomUUID())
                        .path(request.getDescription(false).substring(4))
                        .exception(exception.getClass().getName())
                        .message(exception.getMessage())
                        .build();

        return handleExceptionInternal(exception, errorDto, new HttpHeaders(), httpStatus, request);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleTypeMismatch(MethodArgumentTypeMismatchException exception, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String type = Objects.requireNonNull(exception.getRequiredType()).getSimpleName();
        Object value = exception.getValue();
        String message = String.format("Yo have to use a valid date in format '%s. The value you introduce is not correct: '%s'",
                type, value);
        ErrorDTO errorDto = ErrorDTO.builder()
                .timestamp(ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Z")))
                .status(String.valueOf(httpStatus.value()))
                .logRef(UUID.randomUUID())
                .path(request.getDescription(false).substring(4))
                .exception(exception.getClass().getName())
                .message(message)
                .build();
        return handleExceptionInternal(exception, errorDto, new HttpHeaders(), httpStatus, request);
    }
}