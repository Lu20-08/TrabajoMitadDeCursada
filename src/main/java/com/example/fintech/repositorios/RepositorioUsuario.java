package com.example.fintech.repositorios;

import com.example.fintech.Moldes.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    List<Usuario> findBySurnameContainingIgnoreCase(String surname);
    boolean existsById(Long id);
    boolean existsByDni(String dni);
}