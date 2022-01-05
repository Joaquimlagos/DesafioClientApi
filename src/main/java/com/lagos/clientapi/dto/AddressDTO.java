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

  private String logradouro;

  @NotNull
  @Max(500)
  private Integer houseNumber;

  private String complement;

  private String bairro;

  private String localidade;

  private String uf;

  @NotEmpty
  @Size(min = 8, max = 9)
  private String cep;

}