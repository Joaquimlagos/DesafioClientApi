package com.lagos.clientapi.mapper;

import com.lagos.clientapi.dto.ClientDTO;
import com.lagos.clientapi.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

  ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

  Client toModel(ClientDTO dto);

  ClientDTO toDTO(Client dto);
}
