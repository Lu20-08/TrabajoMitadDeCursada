package com.example.fintech.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNoEncontradoExcepcion extends RuntimeException {
    public UsuarioNoEncontradoExcepcion(Long id) {
        super("User ID not found" + id);
    }


}
