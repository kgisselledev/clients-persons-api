package com.clientsapi.clients.service;

import com.clientsapi.clients.model.Cliente;
import com.clientsapi.clients.repository.ClienteRepository;
import com.clientsapi.clients.response.ClienteResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public ResponseEntity<ClienteResponse> saveCliente(Cliente cliente) {

        Cliente savedCliente = clienteRepository.save(cliente);


        String successMessage = "Cliente creado exitosamente";


        ClienteResponse response = new ClienteResponse(successMessage, savedCliente);


        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public Cliente getClienteById(Long Id) {
        return clienteRepository.findById(Id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + Id));
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
    @Override
    public Cliente updateCliente(Long Id, Cliente clienteDetails) {
        Cliente cliente = getClienteById(Id);

        cliente.setContraseña(clienteDetails.getContraseña());
        cliente.setEstado(clienteDetails.getEstado());
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setGenero(cliente.getGenero());
        cliente.setEdad(cliente.getEdad());
        cliente.setIdentificacion(cliente.getIdentificacion());
        cliente.setDireccion(cliente.getDireccion());
        cliente.setTelefono(cliente.getTelefono());

        // Puedes realizar más validaciones u operaciones antes de guardar la actualización

        return clienteRepository.save(cliente);
    }
    @Override
    public void deleteCliente(Long Id) {
        Cliente cliente = getClienteById(Id);
        clienteRepository.delete(cliente);
    }

}
