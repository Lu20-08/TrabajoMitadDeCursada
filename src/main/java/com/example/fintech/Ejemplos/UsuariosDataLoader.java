package com.example.fintech.Ejemplos;

import com.example.fintech.Moldes.Usuario;
import com.example.fintech.repositorios.RepositorioUsuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuariosDataLoader implements CommandLineRunner {

    private final RepositorioUsuario repositorioUsuario;

    public UsuariosDataLoader(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public void run(String... args) {
        if (repositorioUsuario.count() > 0) {
            return; // already loaded, don't duplicate
        }

        repositorioUsuario.save(crearUsuario("Ana", "Pérez", "30111222", "1122334455", "ana@mail.com"));
        repositorioUsuario.save(crearUsuario("Luis", "Gómez", "28333444", "1155667788", "luis@mail.com"));
        repositorioUsuario.save(crearUsuario("María", "López", "35555666", "1144556677", "maria@mail.com"));
        repositorioUsuario.save(crearUsuario("Carlos", "Díaz", "32777888", "1133221100", "carlos@mail.com"));
        repositorioUsuario.save(crearUsuario("Sofía", "Ruiz", "40999000", "1166778899", "sofia@mail.com"));
    }

    private Usuario crearUsuario(String name, String surname, String dni, String phone, String mail) {
        Usuario u = new Usuario();
        u.setName(name);
        u.setSurname(surname);
        u.setDni(dni);
        u.setPhoneNumber(phone);
        u.setMailAddress(mail);
        return u;
    }
}