package com.lagos.clientapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "client_id")
  private Long id;

  @Column(nullable = false)
  private String logradouro;

  @Column(nullable = false)
  private Integer houseNumber;

  @Column(nullable = false)
  private String complement;

  @Column(nullable = false)
  private String bairro;

  @Column(nullable = false)
  private String localidade;

  @Column(nullable = false)
  private String uf;

  @Column(nullable = false)
  private String cep;

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "client_id", nullable = false)
  private Client client;
}