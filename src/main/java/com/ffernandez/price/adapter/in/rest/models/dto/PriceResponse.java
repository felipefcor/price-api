package com.ffernandez.price.adapter.in.rest.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * PriceResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-02T21:30:28.937520300+02:00[Europe/Madrid]")
public class PriceResponse {

    @JsonProperty("productId")
    private Long productId;

    @JsonProperty("brandId")
    private Long brandId;

    @JsonProperty("rate")
    private Double rate;

    @JsonProperty("date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    @JsonProperty("price")
    private Double price;

    public PriceResponse productId(Long productId) {
        this.productId = productId;
        return this;
    }

    /**
     * Numeric ID of the product
     *
     * @return productId
     */

    @Schema(name = "productId", example = "1", description = "Numeric ID of the product", required = false)
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public PriceResponse brandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    /**
     * Numeric ID of the brand
     *
     * @return brandId
     */

    @Schema(name = "brandId", example = "1", description = "Numeric ID of the brand", required = false)
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public PriceResponse rate(Double rate) {
        this.rate = rate;
        return this;
    }

    /**
     * Apply rate
     *
     * @return rate
     */

    @Schema(name = "rate", example = "5", description = "Apply rate", required = false)
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public PriceResponse date(LocalDateTime date) {
        this.date = date;
        return this;
    }

    /**
     * Apply date pricing
     *
     * @return date
     */
    @Valid
    @Schema(name = "date", description = "Apply date pricing", required = false)
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public PriceResponse price(Double price) {
        this.price = price;
        return this;
    }

    /**
     * Apply price
     *
     * @return price
     */

    @Schema(name = "price", example = "10", description = "Apply price", required = false)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PriceResponse priceResponse = (PriceResponse) o;
        return Objects.equals(this.productId, priceResponse.productId) &&
                Objects.equals(this.brandId, priceResponse.brandId) &&
                Objects.equals(this.rate, priceResponse.rate) &&
                Objects.equals(this.date, priceResponse.date) &&
                Objects.equals(this.price, priceResponse.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, brandId, rate, date, price);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PriceResponse {\n");
        sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
        sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
        sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

