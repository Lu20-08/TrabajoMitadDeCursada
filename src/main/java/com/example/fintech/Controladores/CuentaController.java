package com.example.fintech.Controladores;

import com.example.fintech.CuentaAhorro;
import com.example.fintech.CuentaCorriente;
import com.example.fintech.Moldes.Cuenta;
import com.example.fintech.Servicios.CuentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping
    public List<Cuenta> listAll() {
        return cuentaService.listAll();
    }

    @GetMapping("/{id}")
    public Cuenta searchById(@PathVariable Long id) {
        return cuentaService.searchById(id);
    }

    @PostMapping("/ahorro")
    public Cuenta createAhorro(
            @RequestParam Long usuarioId,
            @RequestBody CuentaAhorro cuenta) {
        return cuentaService.create(usuarioId, cuenta);
    }

    @PostMapping("/corriente")
    public Cuenta createCorriente(
            @RequestParam Long usuarioId,
            @RequestBody CuentaCorriente cuenta) {
        return cuentaService.create(usuarioId, cuenta);
    }

    @PutMapping("/{id}")
    public Cuenta update(
            @PathVariable Long id,
            @RequestBody Cuenta dataUpdate) {
        return cuentaService.update(id, dataUpdate);
    }
}