package com.ffernandez.price.adapter.in.rest.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.Arrays;
import java.util.Objects;

/**
 * Price400Response
 */

@JsonTypeName("Price_400_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-02T21:30:28.937520300+02:00[Europe/Madrid]")
public class Price400Response {

    @JsonProperty("status")
    private JsonNullable<Object> status = JsonNullable.undefined();

    @JsonProperty("path")
    private JsonNullable<Object> path = JsonNullable.undefined();

    @JsonProperty("apiVersion")
    private String apiVersion;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("logRef")
    private String logRef;

    @JsonProperty("exception")
    private String exception;

    @JsonProperty("message")
    private String message;

    public Price400Response status(Object status) {
        this.status = JsonNullable.of(status);
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */

    @Schema(name = "status", example = "400", required = false)
    public JsonNullable<Object> getStatus() {
        return status;
    }

    public void setStatus(JsonNullable<Object> status) {
        this.status = status;
    }

    public Price400Response path(Object path) {
        this.path = JsonNullable.of(path);
        return this;
    }

    /**
     * Get path
     *
     * @return path
     */

    @Schema(name = "path", example = "/prices", required = false)
    public JsonNullable<Object> getPath() {
        return path;
    }

    public void setPath(JsonNullable<Object> path) {
        this.path = path;
    }

    public Price400Response apiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    /**
     * API version
     *
     * @return apiVersion
     */
    @NotNull
    @Schema(name = "apiVersion", example = "1.0.0", description = "API version", required = true)
    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public Price400Response timestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Timestamp
     *
     * @return timestamp
     */
    @NotNull
    @Schema(name = "timestamp", example = "2022-07-01T06:57:02.283+00:00", description = "Timestamp", required = true)
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Price400Response logRef(String logRef) {
        this.logRef = logRef;
        return this;
    }

    /**
     * Log reference
     *
     * @return logRef
     */

    @Schema(name = "logRef", example = "a6f00445-bcb7-4858-a493-34e982d9b65a", description = "Log reference", required = false)
    public String getLogRef() {
        return logRef;
    }

    public void setLogRef(String logRef) {
        this.logRef = logRef;
    }

    public Price400Response exception(String exception) {
        this.exception = exception;
        return this;
    }

    /**
     * Exception name
     *
     * @return exception
     */
    @NotNull
    @Schema(name = "exception", example = "RuntimeException", description = "Exception name", required = true)
    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Price400Response message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Error description
     *
     * @return message
     */
    @NotNull
    @Schema(name = "message", description = "Error description", required = true)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price400Response price400Response = (Price400Response) o;
        return equalsNullable(this.status, price400Response.status) &&
                equalsNullable(this.path, price400Response.path) &&
                Objects.equals(this.apiVersion, price400Response.apiVersion) &&
                Objects.equals(this.timestamp, price400Response.timestamp) &&
                Objects.equals(this.logRef, price400Response.logRef) &&
                Objects.equals(this.exception, price400Response.exception) &&
                Objects.equals(this.message, price400Response.message);
    }

    private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
        return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashCodeNullable(status), hashCodeNullable(path), apiVersion, timestamp, logRef, exception, message);
    }

    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Price400Response {\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    apiVersion: ").append(toIndentedString(apiVersion)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    logRef: ").append(toIndentedString(logRef)).append("\n");
        sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

