package com.lagos.clientapi.exeption;

import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class ApiError {

  private HttpStatus status;
  private List<String> errors;

  public ApiError(HttpStatus status, List<String> errors) {
    super();
    this.status = status;
    this.errors = errors;
  }

  public ApiError(HttpStatus status, String error) {
    super();
    this.status = status;
    errors = Arrays.asList(error);
  }

}