package com.clientsapi.clients.service;

import com.clientsapi.clients.model.Cliente;
import com.clientsapi.clients.response.ClienteResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {
    ResponseEntity<ClienteResponse> saveCliente(Cliente cliente);


    Cliente getClienteById(Integer Id);


    List<Cliente> getAllClientes();

    Cliente updateCliente(Integer Id, Cliente clienteDetails);

    void deleteCliente(Integer Id);


}
