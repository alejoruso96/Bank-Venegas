package com.example.bank.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MovimientoRequestDTO {
    private String numeroCuenta;
    private Double valor;
    private String tipoMovimiento;
}