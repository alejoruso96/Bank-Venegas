package com.example.bank.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuentaId;

    @Column(nullable = false, unique = true)
    private String numeroCuenta;

    @Column(nullable = false)
    private String tipoCuenta;

    @Column(nullable = false)
    private Double saldoInicial;

    @Column(nullable = false)
    private Boolean estado;

    @Column(nullable = false)
    private Long clienteId;
}