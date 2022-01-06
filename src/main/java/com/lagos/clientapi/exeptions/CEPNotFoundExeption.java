package com.lagos.clientapi.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CEPNotFoundExeption extends RuntimeException {

  public CEPNotFoundExeption(String cep) {
    super(String.format("CEP with CEP %s not found!", cep));
  }
}