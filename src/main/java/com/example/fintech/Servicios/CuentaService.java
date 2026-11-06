package com.example.fintech.Servicios;


import com.example.fintech.Moldes.Cuenta;
import com.example.fintech.Moldes.Usuario;
import com.example.fintech.repositorios.RepositorioCuenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {

    private final RepositorioCuenta repositorioCuenta;
    private final UsuarioService usuarioService;

    public CuentaService(RepositorioCuenta repositorioCuenta, UsuarioService usuarioService) {
        this.repositorioCuenta = repositorioCuenta;
        this.usuarioService = usuarioService;
    }

    public List<Cuenta> listAll() {
        return repositorioCuenta.findAll();
    }

    public Cuenta searchById(Long id) {
        return repositorioCuenta.findById(id).orElse(null);
    }


    public List<Cuenta> findByUsuarioId(Long usuarioId) {
        return repositorioCuenta.findByUsuarioId(usuarioId);
    }

    public Cuenta create(Long usuarioId, Cuenta cuenta) {

        Usuario usuario = usuarioService.searchById(usuarioId);

        if (usuario == null) {
            throw new IllegalArgumentException(
                    "An user with that ID does not exist");
        }

        cuenta.setUsuario(usuario);

        return repositorioCuenta.save(cuenta);
    }

    public Cuenta update(Long id, Cuenta data) {

        Cuenta existe = repositorioCuenta.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "An account with that ID does not exist"));

        existe.setUsuario(data.getUsuario());

        return repositorioCuenta.save(existe);
    }
}
