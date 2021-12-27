package com.lagos.clientapi.controllers;

import com.lagos.clientapi.dto.ClientDTO;
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
  public ClientDTO create(@RequestBody @Valid ClientDTO clientDTO){
    return clientService.createClient(clientDTO);
  }
/*
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
    return personService.findById(id);
  }

  @GetMapping
  public List<PersonDTO> listAll() {
    return personService.listAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
    return personService.update(id, personDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) throws PersonNotFoundException {
    personService.delete(id);
  }
 */
}
