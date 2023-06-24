package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.UsuarioEntity;
import com.example.dbd.demodbd.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/usuario")
public class UsuarioController {
    public final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/createUsuario/")
    public UsuarioEntity createUsuario(@RequestBody UsuarioEntity clasificacionEntity){
        return usuarioService.createUsuarios(clasificacionEntity);
    }

    @GetMapping("/getUsuarios/")
    public List<UsuarioEntity> getUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/getUsuarioById/{id}")
    public Optional<UsuarioEntity> getUsuarioById(@PathVariable(value = "id") Long id){
        Optional<UsuarioEntity> optionalUsuarioEntity = usuarioService.getAllUsuariosById(id);
        if(!optionalUsuarioEntity.isPresent()) throw new RuntimeException("El Usuario con el id: " + id + " no existe");
        return optionalUsuarioEntity;
    }

    @PutMapping("/updateUsuario/{id}")
    public UsuarioEntity updateUsuario(@PathVariable(value = "id") Long id, @RequestBody UsuarioEntity clasificacionEntity){
        return usuarioService.updateUsuarios(id, clasificacionEntity);
    }

    @DeleteMapping("/deleteUsuario/{id}")
    public void deleteUsuario(@PathVariable(value = "id") Long id){
        usuarioService.deleteUsuarios(id);
    }
}
