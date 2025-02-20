package com.example.bank.DTO;

import com.example.bank.Model.Movimiento;
import lombok.Data;
import java.util.List;

@Data
public class EstadoCuentaDTO {
    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldoDisponible;
    private List<Movimiento> movimientos;
}