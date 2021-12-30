package com.lagos.clientapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

  private Long id;

  @NotNull
  @Size(min = 1, max = 200)
  private String name;

  @NotNull
  @Size(min = 1, max = 200)
  private String surname;

  @NotEmpty
  //@CPF
  private String cpf;

  @NotNull
  @Email
  private String email;

  @Valid
  private List<PhoneDTO> phones;

  @Valid
  @NotNull
  private AddressDTO address;
}
