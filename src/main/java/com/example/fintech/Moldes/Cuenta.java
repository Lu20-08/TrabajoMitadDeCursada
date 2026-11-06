package com.example.fintech.Moldes;

import com.example.fintech.Cualidades;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter @NoArgsConstructor
public abstract class Cuenta implements Cualidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter(AccessLevel.NONE)
    private BigDecimal balance = BigDecimal.ZERO;

    @Override
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }
        balance = balance.add(amount);
    }

    @Override
    public abstract void withdraw(BigDecimal amount);

    protected void debit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }
        balance = balance.subtract(amount);
    }

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}


