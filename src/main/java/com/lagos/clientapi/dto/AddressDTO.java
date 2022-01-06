package com.lagos.clientapi.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
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

  @JsonProperty("street")
  private String logradouro;

  @NotNull
  @Max(500)
  private Integer houseNumber;

  private String complement;

  @JsonProperty("neighborhood")
  private String bairro;

  @JsonProperty ( "city" )
  private String localidade;

  @JsonProperty("state")
  private String uf;

  @NotEmpty
  @Size(min = 8, max = 9)
  private String cep;

}