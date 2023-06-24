package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.TipoUsuarioEntity;
import com.example.dbd.demodbd.services.TipoUsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/tipoUsuario")
public class TipoUsuarioController {

    public final TipoUsuarioService tipoUsuarioService;
    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService){
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @PostMapping("/createTipoUsuario/")
    public TipoUsuarioEntity createTipoUsuario(@RequestBody TipoUsuarioEntity tipoUsuarioEntity){
        return tipoUsuarioService.createTiposUsuarios(tipoUsuarioEntity);
    }

    @GetMapping("/getTiposUsuarios/")
    public List<TipoUsuarioEntity> getTiposUsuarios(){
        return tipoUsuarioService.getAllTiposUsuarios();
    }

    @GetMapping("/getTipoUsuarioById/{id}")
    public Optional<TipoUsuarioEntity> getTipoUsuarioById(@PathVariable(value = "id") Integer id){
        Optional<TipoUsuarioEntity> optionalTipoUsuarioEntity = tipoUsuarioService.getAllTiposUsuariosById(id);
        if(!optionalTipoUsuarioEntity.isPresent()) throw new RuntimeException("El Tipo Usuario con el id: " + id + " no existe");
        return optionalTipoUsuarioEntity;
    }

    @PutMapping("/updateTipoUsuario/{id}")
    public TipoUsuarioEntity updateTipoUsuario(@PathVariable(value = "id") Integer id, @RequestBody TipoUsuarioEntity tipoUsuarioEntity){
        return tipoUsuarioService.updateTiposUsuarios(id, tipoUsuarioEntity);
    }

    @DeleteMapping("/deleteTipoUsuario/{id}")
    public void deleteTipoUsuario(@PathVariable(value = "id") Integer id){
        tipoUsuarioService.deleteTiposUsuarios(id);
    }

}
