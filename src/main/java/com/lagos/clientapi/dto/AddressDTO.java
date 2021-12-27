package com.lagos.clientapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

  private Long id;

  @NotEmpty
  private String longadouro;

  @NotNull
  @Max(500)
  private Integer houseNumber;

  private String complemento;

  @NotEmpty
  private String bairro;

  @NotEmpty
  private String city;

  @NotEmpty
  private String state;

  @NotEmpty
  @Size(min = 8, max = 8)
  private String cep;

}