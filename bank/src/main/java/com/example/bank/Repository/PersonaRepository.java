package com.example.bank.Repository;

import com.example.bank.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Persona findByIdentificacion(String identificacion);
}