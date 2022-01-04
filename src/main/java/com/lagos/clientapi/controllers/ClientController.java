package com.lagos.clientapi.controllers;

import com.lagos.clientapi.dto.ClientDTO;
import com.lagos.clientapi.exeption.ClientNotFoundExeption;
import com.lagos.clientapi.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {

  private final ClientService clientService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ClientDTO createClient(@Valid @RequestBody  ClientDTO clientDTO) {
      return clientService.createClient(clientDTO);
  }
  @GetMapping("/{id}")
    public ClientDTO findByName(@PathVariable Long id) throws ClientNotFoundExeption {
        return clientService.findById(id);
    }
  @GetMapping
  public List<ClientDTO> listAllClients() {
    return clientService.listAll();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteClient(@PathVariable Long id) throws ClientNotFoundExeption {
    clientService.delete(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ClientDTO updateClient(@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO) throws ClientNotFoundExeption {
    return clientService.update(id, clientDTO);
  }

}
