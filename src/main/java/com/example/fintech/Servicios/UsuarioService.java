package com.example.fintech.Servicios;

import com.example.fintech.Excepciones.UsuarioNoEncontradoExcepcion;
import com.example.fintech.Moldes.Usuario;
import com.example.fintech.repositorios.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final RepositorioUsuario repositorioUsuario;

    public UsuarioService(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;

    }

    public List<Usuario> listAll() {
        return repositorioUsuario.findAll();
    }

    public Usuario searchById(Long id) {
        return repositorioUsuario.findById(id).orElse(null);
    }

    public List<Usuario> findBySurname(String surname) {
        return repositorioUsuario.findBySurnameContainingIgnoreCase(surname);
    }

    public Usuario create(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public Usuario update(Long id, Usuario data) {
        Usuario exists = repositorioUsuario.findById(id).orElseThrow(() -> new UsuarioNoEncontradoExcepcion(id));

        if (!exists.getDni().equals(data.getDni()) && repositorioUsuario.existsByDni(data.getDni())) {
            throw new IllegalArgumentException("A user with that DNI number already exists");
        }
        exists.setName(data.getName());
        exists.setSurname(data.getSurname());
        exists.setDni(data.getDni());
        exists.setPhoneNumber(data.getPhoneNumber());
        exists.setMailAddress(data.getMailAddress());

        return repositorioUsuario.save(exists);
    }



}