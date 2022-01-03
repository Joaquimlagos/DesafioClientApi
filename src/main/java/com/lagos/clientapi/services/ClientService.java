package com.lagos.clientapi.services;

import com.lagos.clientapi.dto.ClientDTO;
import com.lagos.clientapi.entities.Client;
import com.lagos.clientapi.exeption.ClientNotFoundExeption;
import com.lagos.clientapi.mapper.ClientMapper;
import com.lagos.clientapi.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

  private final ClientRepository clientRepository;
  private final ClientMapper clientMapper = ClientMapper.INSTANCE;

  public ClientDTO createClient(ClientDTO clientDTO) {
    Client client = clientMapper.toModel(clientDTO);
    Client savedClient = clientRepository.save(client);

    return clientMapper.toDTO(savedClient);
  }

  public ClientDTO findById(Long id) throws ClientNotFoundExeption {
    Client foundClient = clientRepository.findById(id)
            .orElseThrow(() -> new ClientNotFoundExeption(id));
    return clientMapper.toDTO(foundClient);
  }
  public List<ClientDTO> listAll() {
    return clientRepository.findAll()
            .stream()
            .map(clientMapper::toDTO)
            .collect(Collectors.toList());
  }

  public void delete(Long id) throws ClientNotFoundExeption {
    clientRepository.findById(id)
            .orElseThrow(() -> new ClientNotFoundExeption(id));
    clientRepository.deleteById(id);
  }
  public ClientDTO update(Long id, ClientDTO clientDTO) throws ClientNotFoundExeption {
    clientRepository.findById(id)
            .orElseThrow(() -> new ClientNotFoundExeption(id));

    Client updatedClient = clientMapper.toModel(clientDTO);
    Client savedPerson = clientRepository.save(updatedClient);
    return clientMapper.toDTO(savedPerson);
  }
}