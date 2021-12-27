package com.lagos.clientapi.services;

import com.lagos.clientapi.dto.ClientDTO;
import com.lagos.clientapi.entities.Client;
import com.lagos.clientapi.mapper.ClientMapper;
import com.lagos.clientapi.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

  private final ClientRepository clientRepository;
  private final ClientMapper clientMapper = ClientMapper.INSTANCE;

  public ClientDTO createClient(ClientDTO clientDTO){
    Client client = clientMapper.toModel(clientDTO);
    Client savedClient = clientRepository.save(client);
    return clientMapper.toDTO(savedClient);
  }

}