package com.clientsapi.clients.controller;

import com.clientsapi.clients.model.Cliente;
import com.clientsapi.clients.response.ClienteResponse;
import com.clientsapi.clients.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ClienteController.class)
@AutoConfigureMockMvc
public class ClienteIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;


    @Test
    public void testCrearCliente() throws Exception {
        Cliente nuevoCliente = new Cliente();

        when(clienteService.saveCliente(any(Cliente.class)))
                .thenReturn(ResponseEntity.ok(new ClienteResponse("Usuario creado exitosamente", new Cliente())));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(nuevoCliente)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        verify(clienteService, times(1)).saveCliente(any(Cliente.class));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

