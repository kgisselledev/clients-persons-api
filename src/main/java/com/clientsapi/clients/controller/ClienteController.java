package com.clientsapi.clients.controller;

import com.clientsapi.clients.model.Cliente;
import com.clientsapi.clients.response.ClienteResponse;
import com.clientsapi.clients.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteResponse> createCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @GetMapping("/{Id}")
    public Cliente getClienteById(@PathVariable Long Id) {
        return clienteService.getClienteById(Id);
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @PutMapping("/{Id}")
    public Cliente updateCliente(@PathVariable Long Id, @RequestBody Cliente clienteDetails) {
        return clienteService.updateCliente(Id, clienteDetails);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long Id) {
        clienteService.deleteCliente(Id);
        return ResponseEntity.ok().build();
    }
}
