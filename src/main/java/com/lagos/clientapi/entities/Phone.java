package com.lagos.clientapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "phone")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "client_apelido", insertable = false, updatable = false)
  private String apelido;

  @Column(nullable = false, unique = true)
  private Integer ddd;

  @Column(nullable = false, unique = true)
  private String number;

  @Column(nullable = false)
  private Boolean active;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "client_apelido", nullable = false)
  private Client client;
}