package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.UsuarioSuscripcionEntity;
import com.example.dbd.demodbd.entities.UsuarioEntity;
import com.example.dbd.demodbd.entities.UsuarioSuscripcionId;
import com.example.dbd.demodbd.services.UsuarioSuscripcionService;
import com.example.dbd.demodbd.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/usuarioSuscripcionSuscripcion")
public class UsuarioSuscripcionController {
    public final UsuarioSuscripcionService usuarioSuscripcionService;
    public UsuarioSuscripcionController(UsuarioSuscripcionService usuarioSuscripcionService){
        this.usuarioSuscripcionService = usuarioSuscripcionService;
    }

    @PostMapping("/createUsuarioSuscripcion/")
    public UsuarioSuscripcionEntity createUsuarioSuscripcion(@RequestBody UsuarioSuscripcionEntity usuarioSuscripcionEntity){
        return usuarioSuscripcionService.createUsuariosSuscripcion(usuarioSuscripcionEntity);
    }

    @GetMapping("/getUsuariosSuscripcion/")
    public List<UsuarioSuscripcionEntity> getUsuariosSuscripcion(){
        return usuarioSuscripcionService.getAllUsuariosSuscripcion();
    }

    @GetMapping("/getUsuarioSuscripcionById/{id}")
    public Optional<UsuarioSuscripcionEntity> getUsuarioSuscripcionById(@PathVariable(value = "id") UsuarioSuscripcionId id){
        Optional<UsuarioSuscripcionEntity> optionalUsuarioSuscripcionEntity = usuarioSuscripcionService.getAllUsuariosSuscripcionById(id);
        if(!optionalUsuarioSuscripcionEntity.isPresent()) throw new RuntimeException("El Usuario Suscripcion con el id: " + id + " no existe");
        return optionalUsuarioSuscripcionEntity;
    }

    @PutMapping("/updateUsuarioSuscripcion/{id}")
    public UsuarioSuscripcionEntity updateUsuarioSuscripcion(@PathVariable(value = "id") UsuarioSuscripcionId id, @RequestBody UsuarioSuscripcionEntity usuarioSuscripcionEntity){
        return usuarioSuscripcionService.updateUsuariosSuscripcion(id, usuarioSuscripcionEntity);
    }

    @DeleteMapping("/deleteUsuarioSuscripcion/{id}")
    public void deleteUsuarioSuscripcion(@PathVariable(value = "id") UsuarioSuscripcionId id){
        usuarioSuscripcionService.deleteUsuariosSuscripcion(id);
    }

}