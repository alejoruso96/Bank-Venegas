package com.example.bank.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "Cliente")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "clienteId")
public class Cliente extends Persona {
    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private Boolean estado;
}