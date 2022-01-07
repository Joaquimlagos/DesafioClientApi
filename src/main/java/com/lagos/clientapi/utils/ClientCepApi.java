package com.lagos.clientapi.utils;

import com.lagos.clientapi.dto.ClientDTO;
import com.lagos.clientapi.entities.Address;
import com.lagos.clientapi.exeptions.CEPNotFoundExeption;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientCepApi {

  public ClientDTO getCepApi(ClientDTO clientDTO) {
    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "https://viacep.com.br/ws/";
    ResponseEntity<Address> response
            = restTemplate.getForEntity(fooResourceUrl + clientDTO.getAddress().getCep() + "/json/", Address.class);

    if (response.getBody().getLogradouro() == null){
      throw new CEPNotFoundExeption(clientDTO.getAddress().getCep());
    }

    clientDTO.getAddress().setLocalidade(response.getBody().getLocalidade());
    clientDTO.getAddress().setBairro(response.getBody().getBairro());
    clientDTO.getAddress().setUf(response.getBody().getUf());
    clientDTO.getAddress().setLogradouro(response.getBody().getLogradouro());

    return clientDTO;
  }

}
