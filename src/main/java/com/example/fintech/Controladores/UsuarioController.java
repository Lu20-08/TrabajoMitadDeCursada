package com.example.fintech.Controladores;


import com.example.fintech.Moldes.Usuario;
import com.example.fintech.Servicios.UsuarioService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService UsuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        UsuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> list(@RequestParam(required = false) String surname) {
        if (surname == null || surname.isBlank()) {
            return UsuarioService.listAll();
        }
        return UsuarioService.findBySurname(surname);
    }

    @GetMapping("/{id}")
    public Usuario searchById(@PathVariable Long id) {
        return UsuarioService.searchById(id);
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return UsuarioService.create(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario dataUpdate ) {
       return UsuarioService.update(id, dataUpdate);
    }


}
