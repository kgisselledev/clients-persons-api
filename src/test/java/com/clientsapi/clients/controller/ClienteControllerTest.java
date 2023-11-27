package com.clientsapi.clients.controller;

import com.clientsapi.clients.model.Cliente;
import com.clientsapi.clients.producer.producer;
import com.clientsapi.clients.repository.ClienteRepository;
import com.clientsapi.clients.response.ClienteResponse;
import com.clientsapi.clients.service.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ClienteControllerTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private producer rabbitMQProducer;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveCliente() {
        Cliente cliente = new Cliente();

        when(clienteRepository.save(any(Cliente.class))).thenReturn(new Cliente());

        ResponseEntity<ClienteResponse> resultado = clienteService.saveCliente(cliente);

        assertNotNull(resultado);
        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());

        verify(clienteRepository, times(1)).save(any(Cliente.class));


    }
}