package com.lagos.clientapi.builder;


import com.lagos.clientapi.dto.AddressDTO;
import com.lagos.clientapi.entities.Address;

public class AddressDTOBuilder {

  private static final Long ID = 1L;
  private static final String STREET = "servidão teste";
  private static final Integer HOUSENUMBER = 12;
  private static final String CEP = "12345678";
  private static final String COMPLEMENT = "12";
  private static final String NEIGHBORHOOD = "ingleses";
  private static final String CITY = "São Paulo";
  private static final String STATE = "São Paulo";

  public static AddressDTO createFakeDTO() {
    return AddressDTO.builder()
            .id(ID)
            .street(STREET)
            .houseNumber(HOUSENUMBER)
            .complement(COMPLEMENT)
            .neighborhood(NEIGHBORHOOD)
            .city(CITY)
            .state(STATE)
            .cep(CEP)
            .build();
  }

  public static Address createFakeEntity() {
    return Address.builder()
            .id(ID)
            .houseNumber(HOUSENUMBER)
            .complement(COMPLEMENT)
            .neighborhood(NEIGHBORHOOD)
            .city(CITY)
            .state(STATE)
            .cep(CEP)
            .build();
  }
}

