package com.example.bank.Controller;

import com.example.bank.DTO.EstadoCuentaDTO;
import com.example.bank.DTO.MovimientoRequestDTO;
import com.example.bank.Model.Cuenta;
import com.example.bank.Model.Movimiento;
import com.example.bank.Service.CuentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
@RequiredArgsConstructor
public class CuentaController {
    private final CuentaService cuentaService;

    @PostMapping("/{numeroCuenta}/movimientos")
    public ResponseEntity<Movimiento> realizarMovimiento(
            @RequestParam MovimientoRequestDTO request) {
        return ResponseEntity.ok(cuentaService.realizarMovimiento(request));
    }

}