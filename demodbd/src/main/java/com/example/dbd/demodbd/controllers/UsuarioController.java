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

    @PostMapping
    public UsuarioEntity crearUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        return usuarioService.saveUsuario(usuarioEntity);
    }

    @GetMapping("/{id}")
    public UsuarioEntity obtenerUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

//    @DeleteMapping("/{id}")
//    public void eliminarUsuarioById(@PathVariable Long id) {
//        usuarioService.deleteUsuarioById(id);
//    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}
