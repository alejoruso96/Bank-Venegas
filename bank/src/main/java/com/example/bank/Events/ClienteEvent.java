package com.example.bank.Events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEvent {
    private Long clienteId;
    private String tipoOperacion;  // CREATED, UPDATED, DELETED
    private String nombreCliente;
    private String identificacion;

    // Constructor simplificado para operaciones básicas
    public ClienteEvent(Long clienteId, String tipoOperacion) {
        this.clienteId = clienteId;
        this.tipoOperacion = tipoOperacion;
    }
}
