package com.example.bank.Service;

import com.example.bank.Model.Cuenta;
import com.example.bank.Model.Movimiento;
import com.example.bank.Repository.CuentaRepository;
import com.example.bank.Repository.MovimientoRepository;
import com.example.bank.Exception.SaldoNoDisponibleException;
import com.example.bank.Exception.CuentaNotFoundException;
import com.example.bank.DTO.MovimientoRequestDTO;
import com.example.bank.DTO.EstadoCuentaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CuentaService {
    private final CuentaRepository cuentaRepository;
    private final MovimientoRepository movimientoRepository;

    @Transactional
    public Movimiento realizarMovimiento(MovimientoRequestDTO request) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(request.getNumeroCuenta())
                .orElseThrow(() -> new CuentaNotFoundException("Cuenta no encontrada: " + request.getNumeroCuenta()));

        if (!cuenta.getEstado()) {
            throw new RuntimeException("La cuenta está inactiva");
        }

        Double valorMovimiento = request.getValor();
        if (valorMovimiento < 0 && Math.abs(valorMovimiento) > cuenta.getSaldoInicial()) {
            throw new SaldoNoDisponibleException("Saldo insuficiente para realizar el retiro");
        }

        Movimiento movimiento = new Movimiento();
        movimiento.setFecha(LocalDateTime.now());
        movimiento.setTipoMovimiento(valorMovimiento > 0 ? "Deposito" : "Retiro");
        movimiento.setValor(valorMovimiento);
        movimiento.setCuenta(cuenta);
        movimiento.setSaldo(cuenta.getSaldoInicial() + valorMovimiento);

        cuenta.setSaldoInicial(cuenta.getSaldoInicial() + valorMovimiento);
        cuentaRepository.save(cuenta);
        return movimientoRepository.save(movimiento);
    }

    public EstadoCuentaDTO generarEstadoCuenta(Long clienteId, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        List<Movimiento> movimientos = movimientoRepository
                .findByCuenta_ClienteIdAndFechaBetweenOrderByFechaDesc(clienteId, fechaInicio, fechaFin);

        // Implementar la lógica para generar el estado de cuenta
        EstadoCuentaDTO estadoCuenta = new EstadoCuentaDTO();
        // Llenar el DTO con la información necesaria
        return estadoCuenta;
    }
}