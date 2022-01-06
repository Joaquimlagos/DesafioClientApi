package com.lagos.clientapi.builder;


import com.lagos.clientapi.dto.AddressDTO;
import com.lagos.clientapi.entities.Address;

public class AddressDTOBuilder {

  private static final Long ID = 1L;
  private static final String STREET = "Servidão Jarbas D'Oliveira";
  private static final Integer HOUSENUMBER = 12;
  private static final String CEP = "88058448";
  private static final String COMPLEMENT = "12";
  private static final String NEIGHBORHOOD = "Ingleses do Rio Vermelho";
  private static final String CITY = "Florianópolis";
  private static final String STATE = "SC";

  public static AddressDTO createFakeDTO() {
    return AddressDTO.builder()
            .id(ID)
            .houseNumber(HOUSENUMBER)
            .complement(COMPLEMENT)
            .cep(CEP)
            .build();
  }

  public static Address createFakeEntity() {
    return Address.builder()
            .id(ID)
            .houseNumber(HOUSENUMBER)
            .complement(COMPLEMENT)
            .cep(CEP)
            .build();
  }
}

