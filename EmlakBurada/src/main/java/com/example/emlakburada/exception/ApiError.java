package com.example.emlakburada.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    @JsonProperty("error")
    private String message;

    @JsonProperty("error_description")
    private String debugMessage;

    @JsonProperty("sub_errors")
    private List<String> subErrors;

    
    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    ApiError(HttpStatus status, Exception ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    ApiError( String message, String debugMessage, HttpStatus status) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = debugMessage;
    }

    ApiError( String message, HttpStatus status, List<String> subErrors) {
        this();
        this.status = status;
        this.message = message;
        this.subErrors = subErrors;
    }
}
