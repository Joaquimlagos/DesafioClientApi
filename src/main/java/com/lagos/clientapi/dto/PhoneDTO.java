package com.lagos.clientapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {

  private Long id;

  @NotNull
  @Max(500)
  private Integer ddd;

  @NotEmpty
  @Size(min = 13, max = 14)
  private String number;

  @NotNull
  private Boolean active;
}