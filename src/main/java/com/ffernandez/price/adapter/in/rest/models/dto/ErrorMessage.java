package com.ffernandez.price.adapter.in.rest.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * ErrorMessage
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-02T21:30:28.937520300+02:00[Europe/Madrid]")
public class ErrorMessage {

    @JsonProperty("apiVersion")
    private String apiVersion;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("status")
    private String status;

    @JsonProperty("logRef")
    private String logRef;

    @JsonProperty("path")
    private String path;

    @JsonProperty("exception")
    private String exception;

    @JsonProperty("message")
    private String message;

    public ErrorMessage apiVersion(String apiVersion) {
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

    public ErrorMessage timestamp(String timestamp) {
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

    public ErrorMessage status(String status) {
        this.status = status;
        return this;
    }

    /**
     * HTTP code status
     *
     * @return status
     */
    @NotNull
    @Schema(name = "status", description = "HTTP code status", required = true)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ErrorMessage logRef(String logRef) {
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

    public ErrorMessage path(String path) {
        this.path = path;
        return this;
    }

    /**
     * Endpoint path
     *
     * @return path
     */
    @NotNull
    @Schema(name = "path", description = "Endpoint path", required = true)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ErrorMessage exception(String exception) {
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

    public ErrorMessage message(String message) {
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
        ErrorMessage errorMessage = (ErrorMessage) o;
        return Objects.equals(this.apiVersion, errorMessage.apiVersion) &&
                Objects.equals(this.timestamp, errorMessage.timestamp) &&
                Objects.equals(this.status, errorMessage.status) &&
                Objects.equals(this.logRef, errorMessage.logRef) &&
                Objects.equals(this.path, errorMessage.path) &&
                Objects.equals(this.exception, errorMessage.exception) &&
                Objects.equals(this.message, errorMessage.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiVersion, timestamp, status, logRef, path, exception, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorMessage {\n");
        sb.append("    apiVersion: ").append(toIndentedString(apiVersion)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    logRef: ").append(toIndentedString(logRef)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

