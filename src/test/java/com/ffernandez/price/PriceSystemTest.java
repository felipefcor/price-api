package com.ffernandez.price;

import com.ffernandez.price.application.port.in.PriceUseCase;
import com.ffernandez.price.domain.mother.TotalPriceMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class PriceSystemTest {
    @LocalServerPort
    int port;
    public static final long BRAND_ID = 1L;
    public static final long PRODUCT_ID = 35455L;
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PriceUseCase priceUseCase;

    URI baseURI;

    @BeforeEach
    protected void setUp() {
        baseURI = URI.create("http://localhost:" + port + "/prices");
    }

    @Test
    @DisplayName("Test 1: request at 10 am of 14th with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_14_10am_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        String date = "2020-06-14T10:00:00.00";
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200614And20201231AndPriority0();
        ResponseEntity<?> response = callToServer(date);
        LinkedHashMap<String, Object> bodyMap = (LinkedHashMap<String, Object>) response.getBody();

        assert bodyMap != null;
        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(bodyMap.get("productId")).isEqualTo(expectedTotalPrice.getProductId().getId().intValue());
        then(bodyMap.get("brandId")).isEqualTo(expectedTotalPrice.getBrandId().getId().intValue());
        then(bodyMap.get("rate")).isEqualTo(expectedTotalPrice.getRate().getRate());
        then(bodyMap.get("price")).isEqualTo(expectedTotalPrice.getPrice().getPrice());
        LocalDateTime.parse((CharSequence) bodyMap.get("startDate")).isEqual( expectedTotalPrice.getStartDate());
        LocalDateTime.parse((CharSequence) bodyMap.get("endDate")).isEqual( expectedTotalPrice.getEndDate());
    }

    @Test
    @DisplayName("Test 2: request at 16 pm of 14th of 2020 with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_14_16pm_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        String date = "2020-06-14T16:00:00.00";
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200614And20200614AndPriority1();
        ResponseEntity<?> response = callToServer(date);
        LinkedHashMap<String, Object> bodyMap = (LinkedHashMap<String, Object>) response.getBody();

        assert bodyMap != null;
        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(bodyMap.get("productId")).isEqualTo(expectedTotalPrice.getProductId().getId().intValue());
        then(bodyMap.get("brandId")).isEqualTo(expectedTotalPrice.getBrandId().getId().intValue());
        then(bodyMap.get("rate")).isEqualTo(expectedTotalPrice.getRate().getRate());
        then(bodyMap.get("price")).isEqualTo(expectedTotalPrice.getPrice().getPrice());
        LocalDateTime.parse((CharSequence) bodyMap.get("startDate")).isEqual( expectedTotalPrice.getStartDate());
        LocalDateTime.parse((CharSequence) bodyMap.get("endDate")).isEqual( expectedTotalPrice.getEndDate());
    }

    @Test
    @DisplayName("Test 3: request at 9 pm of 14th of 2020 with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_14_21pm_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        String date = "2020-06-14T21:00:00.00";
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200614And20201231AndPriority0();
        ResponseEntity<?> response = callToServer(date);
        LinkedHashMap<String, Object> bodyMap = (LinkedHashMap<String, Object>) response.getBody();

        assert bodyMap != null;
        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(bodyMap.get("productId")).isEqualTo(expectedTotalPrice.getProductId().getId().intValue());
        then(bodyMap.get("brandId")).isEqualTo(expectedTotalPrice.getBrandId().getId().intValue());
        then(bodyMap.get("rate")).isEqualTo(expectedTotalPrice.getRate().getRate());
        then(bodyMap.get("price")).isEqualTo(expectedTotalPrice.getPrice().getPrice());
        LocalDateTime.parse((CharSequence) bodyMap.get("startDate")).isEqual( expectedTotalPrice.getStartDate());
        LocalDateTime.parse((CharSequence) bodyMap.get("endDate")).isEqual( expectedTotalPrice.getEndDate());
    }

    @Test
    @DisplayName("Test 4: request at 10 am of 15th of 2020 with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_15_10_am_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        String date = "2020-06-15T10:00:00.00";
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200615And20200615AndPriority1();
        ResponseEntity<?> response = callToServer(date);
        LinkedHashMap<String, Object> bodyMap = (LinkedHashMap<String, Object>) response.getBody();

        assert bodyMap != null;
        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(bodyMap.get("productId")).isEqualTo(expectedTotalPrice.getProductId().getId().intValue());
        then(bodyMap.get("brandId")).isEqualTo(expectedTotalPrice.getBrandId().getId().intValue());
        then(bodyMap.get("rate")).isEqualTo(expectedTotalPrice.getRate().getRate());
        then(bodyMap.get("price")).isEqualTo(expectedTotalPrice.getPrice().getPrice());
        LocalDateTime.parse((CharSequence) bodyMap.get("startDate")).isEqual( expectedTotalPrice.getStartDate());
        LocalDateTime.parse((CharSequence) bodyMap.get("endDate")).isEqual( expectedTotalPrice.getEndDate());
    }

    @Test
    @DisplayName("Test 5: request at 9pm of 16th of 2020 with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_16_21pm_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        String date = "2020-06-16T21:00:00.00";
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200615And20201231AndPriority1();
        ResponseEntity<?> response = callToServer(date);
        LinkedHashMap<String, Object> bodyMap = (LinkedHashMap<String, Object>) response.getBody();

        assert bodyMap != null;
        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(bodyMap.get("productId")).isEqualTo(expectedTotalPrice.getProductId().getId().intValue());
        then(bodyMap.get("brandId")).isEqualTo(expectedTotalPrice.getBrandId().getId().intValue());
        then(bodyMap.get("rate")).isEqualTo(expectedTotalPrice.getRate().getRate());
        then(bodyMap.get("price")).isEqualTo(expectedTotalPrice.getPrice().getPrice());
        LocalDateTime.parse((CharSequence) bodyMap.get("startDate")).isEqual( expectedTotalPrice.getStartDate());
        LocalDateTime.parse((CharSequence) bodyMap.get("endDate")).isEqual( expectedTotalPrice.getEndDate());
    }

    private ResponseEntity callToServer(String date) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromUri(baseURI)
                .queryParam("productId", String.valueOf(PRODUCT_ID))
                .queryParam("brandId", String.valueOf(BRAND_ID))
                .queryParam("date", date)
                .encode()
                .toUriString();

        return restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                Object.class);
    }


}
