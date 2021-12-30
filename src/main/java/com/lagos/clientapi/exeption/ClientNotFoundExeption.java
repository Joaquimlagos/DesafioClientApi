package com.lagos.clientapi.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundExeption extends Exception {

  public ClientNotFoundExeption(Long id) {
    super(String.format("Client with ID %s not found!", id));
  }
}