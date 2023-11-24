package com.clientsapi.clients.service;

import com.clientsapi.clients.model.Cliente;
import com.clientsapi.clients.response.ClienteResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {
    ResponseEntity<ClienteResponse> saveCliente(Cliente cliente);

    Cliente getClienteById(Long Id);


    List<Cliente> getAllClientes();

    Cliente updateCliente(Long Id, Cliente clienteDetails);

    void deleteCliente(Long Id);


}
