package com.example.bank.Repository;

import com.example.bank.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByIdentificacion(String identificacion);
}