package com.example.bank.Repository;

import com.example.bank.Model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuenta_ClienteIdAndFechaBetweenOrderByFechaDesc(
            Long clienteId,
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin
    );

    List<Movimiento> findByCuenta_NumeroCuentaOrderByFechaDesc(String numeroCuenta);
}