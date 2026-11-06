package com.example.fintech;

import com.example.fintech.Moldes.Cuenta;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter @Setter @NoArgsConstructor
public class CuentaCorriente extends Cuenta {

    private BigDecimal overdraftLimit = new BigDecimal("1000");

    @Override
    public void withdraw(BigDecimal amount) {
        BigDecimal available = getBalance().add(overdraftLimit);
        if (available.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Supera el limite de descubrimiento");
        }
        debit(amount);
    }
}
