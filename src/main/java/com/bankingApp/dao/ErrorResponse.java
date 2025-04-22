package com.bankingApp.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
public class ErrorResponse {

    private LocalDateTime timestamp;
    private String message;
    private String details;
    private String errorCode;

    public ErrorResponse(LocalDateTime timestamp, String message, String details,String errorCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.errorCode =errorCode;
    }

}
