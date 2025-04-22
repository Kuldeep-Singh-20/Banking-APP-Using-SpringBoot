package com.bankingApp.exception;

import com.bankingApp.dao.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


//
//    @ExceptionHandler(AccountNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleAccountNotFoundException
//            (AccountNotFoundException exception, WebRequest request){
//
//        ErrorDetails response = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                request.getDescription(false),
//                "ACCOUNT_NOT_FOUNDS"
//        );
//
//        return new ResponseEntity<ErrorDetails>(response,HttpStatus.NOT_FOUND);
//    }
//
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorDetails> handleAccountNotFoundException
//            (Exception exception, WebRequest request){
//
//        ErrorDetails response = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                request.getDescription(false),
//                "ACCOUNT NOT FOUND"
//
//        );
//        return new ResponseEntity<ErrorDetails>(response,HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//



    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException
            (AccountNotFoundException exception, WebRequest request){

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false),
                "ACCOUNT_NOT_FOUNDS"
        );

        return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException
            (Exception exception, WebRequest request){

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false),
                "ACCOUNT NOT FOUND"

        );
        return new ResponseEntity<ErrorResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
