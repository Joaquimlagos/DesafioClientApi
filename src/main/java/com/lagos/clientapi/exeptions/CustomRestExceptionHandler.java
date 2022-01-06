package com.lagos.clientapi.exeptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ClientNotFoundExeption.class)
  public ResponseEntity<Object> handleCityNotFoundException(
          ClientNotFoundExeption ex, WebRequest request) {

    Map<String, Object> body = new LinkedHashMap<>();
    body.put("status", HttpStatus.NOT_FOUND);
    body.put("errors", ex.getMessage());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(CEPNotFoundExeption.class)
  public ResponseEntity<Object> handleCityNotFoundException(
          CEPNotFoundExeption ex, WebRequest request) {

    Map<String, Object> body = new LinkedHashMap<>();
    body.put("status", HttpStatus.NOT_FOUND);
    body.put("errors", ex.getMessage());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
          MethodArgumentNotValidException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest request) {
    List<String> errors = new ArrayList<String>();
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      errors.add(error.getField() + ": " + error.getDefaultMessage());
    }
    for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
      errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
    }
    ApiError apiError =
            new ApiError(HttpStatus.BAD_REQUEST, errors);
    return handleExceptionInternal(
            ex, apiError, headers, apiError.getStatus(), request);
  }

}
