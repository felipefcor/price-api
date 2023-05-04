/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.ffernandez.price.adapter.in.rest.models.api;

import com.ffernandez.price.adapter.in.rest.models.dto.Price400Response;
import com.ffernandez.price.adapter.in.rest.models.dto.Price404Response;
import com.ffernandez.price.adapter.in.rest.models.dto.Price500Response;
import com.ffernandez.price.adapter.in.rest.models.dto.PriceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-03T17:43:44.916833700+02:00[Europe/Madrid]")
@Validated
@Tag(name = "Prices", description = "the Prices API")
public interface PricesApi {

    /**
     * GET /prices
     * Filter product&#39;s prices by date
     *
     * @param productId Numeric ID of the product (required)
     * @param brandId Numeric ID of the brand (required)
     * @param date Apply date pricing (required)
     * @return Ok (status code 200)
     *         or Bad Request (status code 400)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "price",
        tags = { "Prices" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Ok", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PriceResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Price400Response.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Price404Response.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Price500Response.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/prices",
        produces = { "application/json" }
    )
    ResponseEntity<PriceResponse> price(
        @NotNull @Parameter(name = "productId", description = "Numeric ID of the product", required = true) @Valid @RequestParam(value = "productId", required = true) Long productId,
        @NotNull @Parameter(name = "brandId", description = "Numeric ID of the brand", required = true) @Valid @RequestParam(value = "brandId", required = true) Long brandId,
        @NotNull @Parameter(name = "date", description = "Apply date pricing", required = true) @Valid @RequestParam(value = "date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) java.time.LocalDateTime date
    );

}
