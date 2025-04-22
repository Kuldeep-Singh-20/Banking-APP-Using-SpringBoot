package com.bankingApp.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
public class ErrorResponse {

    private LocalDateTime timestamp;
    private String message;
    private String details;
    private String erroCode;

    public ErrorResponse(LocalDateTime timestamp, String message, String details,String erroCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.erroCode =erroCode;
    }

}
