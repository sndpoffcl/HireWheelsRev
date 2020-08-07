package com.upgrad.HireWheelsRev.exception.advice;

import com.upgrad.HireWheelsRev.dto.CustomResponse;
import com.upgrad.HireWheelsRev.exception.APIException;
import com.upgrad.HireWheelsRev.exception.UserDetailsNotFoundException;
import com.upgrad.HireWheelsRev.exception.UserRoleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.util.Date;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@ControllerAdvice
public class ApplicationExceptionHandler extends Exception{

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRunTimeException(RuntimeException ex) {
        return error(BAD_REQUEST, ex);
    }

    @ExceptionHandler(UserDetailsNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserDetailsNotFoundException ex) {
        return error(BAD_REQUEST, ex);
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<Object> handleAPIException(APIException ex) {
        return error(BAD_REQUEST, ex);
    }

    @ExceptionHandler({SQLException.class, NullPointerException.class})
    public ResponseEntity<Object> handle(Exception ex) {
        return error(BAD_REQUEST, ex);
    }

    private ResponseEntity error(HttpStatus status, Exception ex) {
        CustomResponse customResponse = new CustomResponse(new Date(), ex.getMessage(), status.value());
        return new ResponseEntity(customResponse, status);
    }

    @ExceptionHandler(UserRoleNotFoundException.class)
    public ResponseEntity<Object> userRoleNotFoundExceptionhandler(Exception ex) {
        return error(BAD_REQUEST, ex);
    }
}