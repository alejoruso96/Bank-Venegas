package com.example.bank.Service;

import com.example.bank.Events.ClienteEvent;
import com.example.bank.Model.Cliente;
import com.example.bank.Repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final KafkaTemplate<String, ClienteEvent> kafkaTemplate;

    public Cliente createCliente(Cliente cliente) {
        Cliente savedCliente = clienteRepository.save(cliente);
        // Notificar al otro microservicio
        kafkaTemplate.send("cliente-events", new ClienteEvent(savedCliente.getPersonaId(), "CREATED"));
        return savedCliente;
    }

    public Cliente updateCliente(Cliente cliente) {
        Cliente updatedCliente = clienteRepository.save(cliente);
        kafkaTemplate.send("cliente-events", new ClienteEvent(updatedCliente.getPersonaId(), "UPDATED"));
        return updatedCliente;
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
        kafkaTemplate.send("cliente-events", new ClienteEvent(id, "DELETED"));
    }

    public Cliente getCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
}