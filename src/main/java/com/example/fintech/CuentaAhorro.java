package com.example.fintech;

import com.example.fintech.Moldes.Cuenta;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class CuentaAhorro extends Cuenta {

    @Override
    public void withdraw(BigDecimal amount) {
        if (getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        debit(amount);
    }
}
