package com.clientsapi.clients.response;

import com.clientsapi.clients.model.Cliente;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ClienteResponse {
    private String message;
    private Cliente cliente;

    public ClienteResponse(String message, Cliente cliente) {
        this.message = message;
        this.cliente = cliente;
    }

}
