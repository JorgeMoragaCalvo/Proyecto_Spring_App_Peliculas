package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.UsuarioSerieEntity;
import com.example.dbd.demodbd.services.UsuarioSerieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/usuariosSeries")
public class UsuarioSerieController {

    public final UsuarioSerieService usuarioSerieService;
    public UsuarioSerieController(UsuarioSerieService usuarioSerieService){
        this.usuarioSerieService = usuarioSerieService;
    }

    @PostMapping("/createUsuarioSerie/")
    public UsuarioSerieEntity createUsuarioSerie(@RequestBody UsuarioSerieEntity usuarioSerieEntity){
        return usuarioSerieService.createUsuariosSeries(usuarioSerieEntity);
    }

    @GetMapping("/getUsuariosSeries/")
    public List<UsuarioSerieEntity> getUsuariosSeries(){
        return usuarioSerieService.getAllUsuariosSeries();
    }

    @GetMapping("/getUsuarioSerieById/{id}")
    public Optional<UsuarioSerieEntity> getUsuarioSerieById(@PathVariable(value = "id") Integer id){
        Optional<UsuarioSerieEntity> optionalUsuarioSerieEntity = usuarioSerieService.getAllUsuariosSeriesById(id);
        if(!optionalUsuarioSerieEntity.isPresent()) throw new RuntimeException("El Usuario-Serie con el id: " + id + " no existe");
        return optionalUsuarioSerieEntity;
    }

    @PutMapping("/updateUsuarioSerie/{id}")
    public UsuarioSerieEntity updateUsuarioSerie(@PathVariable(value = "id") Integer id, @RequestBody UsuarioSerieEntity usuarioSerieEntity){
        return usuarioSerieService.updateUsuariosSeries(id, usuarioSerieEntity);
    }

    @DeleteMapping("/deleteUsuarioSerie/{id}")
    public void deleteUsuarioSerie(@PathVariable(value = "id") Integer id){
        usuarioSerieService.deleteUsuariosSeries(id);
    }

}
