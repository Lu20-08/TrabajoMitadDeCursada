package com.example.fintech.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CuentaNoEncontradaExcepcion extends RuntimeException {

    public CuentaNoEncontradaExcepcion(Long id) {
        super("Could not find an account with the ID: " + id);
    }
}
