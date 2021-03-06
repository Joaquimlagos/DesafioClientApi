package com.lagos.clientapi.builder;


import com.lagos.clientapi.dto.ClientDTO;
import com.lagos.clientapi.entities.Client;

import java.util.Collections;

public class ClientDTOBuilder {

  private static final Long ID = 1L;
  private static final String NAME = "joaquim";
  private static final String SURNAME = "joaca";
  private static final String CPF = "874.658.675-09";
  private static final String EMAIL = "teste@email.com";


  public static ClientDTO createFakeDTO() {
    return ClientDTO.builder()
            .id(ID)
            .name(NAME)
            .surname(SURNAME)
            .cpf(CPF)
            .email(EMAIL)
            .phones(Collections.singletonList(PhoneDTOBuilder.createFakeDTO()))
            .address(AddressDTOBuilder.createFakeDTO())
            .build();
  }

  public static Client createFakeEntity() {
    return Client.builder()
            .id(ID)
            .name(NAME)
            .surname(SURNAME)
            .cpf(CPF)
            .email(EMAIL)
            .phones(Collections.singletonList(PhoneDTOBuilder.createFakeEntity()))
            .address(AddressDTOBuilder.createFakeEntity())
            .build();

  }
}

