package com.lagos.clientapi.controller;

import com.lagos.clientapi.builder.ClientDTOBuilder;
import com.lagos.clientapi.controllers.ClientController;
import com.lagos.clientapi.dto.ClientDTO;
import com.lagos.clientapi.exeption.ClientNotFoundExeption;
import com.lagos.clientapi.services.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Collections;

import static com.lagos.clientapi.utils.JsonConvertionUtils.asJsonString;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

  private static final String CLIENT_API_URL_PATH = "/api/v1/client";

  private MockMvc mockMvc;

  @Mock
  private ClientService clientService;

  @InjectMocks
  private ClientController clientController;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(clientController)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
            .build();
  }

  @Test
  void whenPOSTIsCalledThenAClientIsCreated() throws Exception {
    ClientDTO clientDTO = ClientDTOBuilder.createFakeDTO();

    when(clientService.createClient(clientDTO)).thenReturn(clientDTO);
    mockMvc.perform(post(CLIENT_API_URL_PATH)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(clientDTO)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name", is(clientDTO.getName())))
            .andExpect(jsonPath("$.surname", is(clientDTO.getSurname())))
            .andExpect(jsonPath("$.cpf", is(clientDTO.getCpf())))
            .andExpect(jsonPath("$.email", is(clientDTO.getEmail())));
            //.andExpect(jsonPath("$.phones", is(asJsonString(clientDTO.getPhones()))));
            //.andExpect(jsonPath("$.address", is(asJsonString(clientDTO.getAddress()))));
  }


  @Test
  void whenPOSTIsCalledWithoutRequiredFieldThenAnErrorIsReturned() throws Exception {
    ClientDTO beerDTO = ClientDTOBuilder.createFakeDTO();
    beerDTO.setCpf(null);

    mockMvc.perform(post(CLIENT_API_URL_PATH)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(beerDTO)))
            .andExpect(status().isBadRequest());
  }

  @Test
  void whenGETIsCalledWithValidIdThenOkStatusIsReturned() throws Exception {
    ClientDTO clientDTO = ClientDTOBuilder.createFakeDTO();

    when(clientService.findById(clientDTO.getId())).thenReturn(clientDTO);

    mockMvc.perform(MockMvcRequestBuilders.get(CLIENT_API_URL_PATH + "/" + clientDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

  @Test
  void whenGETIsCalledWithoutRegisteredIdThenNotFoundStatusIsReturned() throws Exception {
    ClientDTO clientDTO = ClientDTOBuilder.createFakeDTO();

    when(clientService.findById(clientDTO.getId())).thenThrow(ClientNotFoundExeption.class);

    mockMvc.perform(MockMvcRequestBuilders.get(CLIENT_API_URL_PATH + "/" + clientDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
  }

  @Test
  void whenGETlistWithoutClientsIsCalledThenOkStatusIsReturned() throws Exception {
    ClientDTO clientDTO = ClientDTOBuilder.createFakeDTO();

    when(clientService.listAll()).thenReturn(Collections.singletonList(clientDTO));

    mockMvc.perform(MockMvcRequestBuilders.get(CLIENT_API_URL_PATH)
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

  @Test
  void whenDELETEIsCalledWithValidIdThenNoContentStatusIsReturned() throws Exception {
    ClientDTO clientDTO = ClientDTOBuilder.createFakeDTO();

    Mockito.doNothing().when(clientService).delete(clientDTO.getId());

    mockMvc.perform(MockMvcRequestBuilders.delete(CLIENT_API_URL_PATH + "/" + clientDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());
  }

  @Test
  void whenUPDATEIsCalledThenAClientIsCreated() throws Exception {
    ClientDTO clientDTO = ClientDTOBuilder.createFakeDTO();
    clientDTO.setEmail("testando@example.com");

    when(clientService.update(clientDTO.getId(), clientDTO)).thenReturn(clientDTO);

    mockMvc.perform(MockMvcRequestBuilders.put(CLIENT_API_URL_PATH + "/" + clientDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(clientDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(clientDTO.getName())))
            .andExpect(jsonPath("$.surname", is(clientDTO.getSurname())))
            .andExpect(jsonPath("$.cpf", is(clientDTO.getCpf())))
            .andExpect(jsonPath("$.email", is(clientDTO.getEmail())));
    //.andExpect(jsonPath("$.phones", is(asJsonString(clientDTO.getPhones()))));
    //.andExpect(jsonPath("$.address", is(asJsonString(clientDTO.getAddress()))));
  }
}