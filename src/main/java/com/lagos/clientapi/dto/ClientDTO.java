package com.lagos.clientapi.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.DeclareError;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.UniqueConstraint;
import javax.validation.Constraint;
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
  @JsonProperty
  @Size(min = 1, max = 200)
  private String name;

  @NotNull
  @Size(min = 1, max = 200)
  private String surname;

  @NotEmpty
  @CPF(message = "CPF Invalid !!")
  private String cpf;

  @NotNull
  @Email(message = "Email Invalid !!")
  private String email;

  @Valid
  private List<PhoneDTO> phones;

  @Valid
  @NotNull
  private AddressDTO address;



}
