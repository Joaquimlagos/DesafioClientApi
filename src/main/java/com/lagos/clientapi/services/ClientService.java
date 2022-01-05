package com.lagos.clientapi.services;

import com.lagos.clientapi.dto.ClientDTO;
import com.lagos.clientapi.entities.Address;
import com.lagos.clientapi.entities.Client;
import com.lagos.clientapi.exeption.ClientNotFoundExeption;
import com.lagos.clientapi.mapper.ClientMapper;
import com.lagos.clientapi.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

  private final ClientRepository clientRepository;
  private final ClientMapper clientMapper = ClientMapper.INSTANCE;

  public ClientDTO createClient(ClientDTO clientDTO) {
    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "https://viacep.com.br/ws/";
    ResponseEntity<Address> response
            = restTemplate.getForEntity(fooResourceUrl + clientDTO.getAddress().getCep() + "/json/", Address.class);
    clientDTO.getAddress().setLocalidade(response.getBody().getLocalidade());
    clientDTO.getAddress().setBairro(response.getBody().getBairro());
    clientDTO.getAddress().setUf(response.getBody().getUf());
    clientDTO.getAddress().setLogradouro(response.getBody().getLogradouro());

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


    //https://h-apigateway.conectagov.estaleiro.serpro.gov.br/api-cep/v1/consulta/cep/60130240
  }
}