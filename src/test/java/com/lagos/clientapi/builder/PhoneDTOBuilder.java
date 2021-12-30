package com.lagos.clientapi.builder;

import com.lagos.clientapi.dto.PhoneDTO;
import com.lagos.clientapi.entities.Phone;

public class PhoneDTOBuilder {

  private static final Long ID = 1L;
  private static final Integer DDD = 12;
  private static final String NUMBER = "99999999";
  private static final Boolean ACTIVE = true;


  public static PhoneDTO createFakeDTO() {
    return PhoneDTO.builder()
            .id(ID)
            .ddd(DDD)
            .number(NUMBER)
            .active(ACTIVE)
            .build();
  }

  public static Phone createFakeEntity() {
    return Phone.builder()
            .id(ID)
            .ddd(DDD)
            .number(NUMBER)
            .active(ACTIVE)
            .build();

  }
}


