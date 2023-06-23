package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.UsuarioEntity;
import com.example.dbd.demodbd.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/crearUsuario/")
    public UsuarioEntity crearUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        return usuarioService.saveUsuario(usuarioEntity);
    }

    @GetMapping("/obtenerUsuarioById/{id}")
    public UsuarioEntity obtenerUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}
