package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.UsuarioPeliculaEntity;
import com.example.dbd.demodbd.services.UsuarioPeliculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/usuariosPeliculas")
public class UsuarioPeliculaController {

    public final UsuarioPeliculaService usuarioPeliculaService;
    public UsuarioPeliculaController(UsuarioPeliculaService usuarioPeliculaService){
        this.usuarioPeliculaService = usuarioPeliculaService;
    }

    @PostMapping("/createUsuarioPelicula/")
    public UsuarioPeliculaEntity createUsuarioPelicula(@RequestBody UsuarioPeliculaEntity usuarioPeliculaEntity){
        return usuarioPeliculaService.createUsuariosPeliculas(usuarioPeliculaEntity);
    }

    @GetMapping("/getUsuariosPeliculas/")
    public List<UsuarioPeliculaEntity> getUsuariosPeliculas(){
        return usuarioPeliculaService.getAllUsuariosPeliculas();
    }

    @GetMapping("/getUsuarioPeliculaById/{id}")
    public Optional<UsuarioPeliculaEntity> getUsuarioPeliculaById(@PathVariable(value = "id") Integer id){
        Optional<UsuarioPeliculaEntity> optionalUsuarioPeliculaEntity = usuarioPeliculaService.getAllUsuariosPeliculasById(id);
        if(!optionalUsuarioPeliculaEntity.isPresent()) throw new RuntimeException("El Usuario-Pelicula con el id: " + id + " no existe");
        return optionalUsuarioPeliculaEntity;
    }

    @PutMapping("/updateUsuarioPelicula/{id}")
    public UsuarioPeliculaEntity updateUsuarioPelicula(@PathVariable(value = "id") Integer id, @RequestBody UsuarioPeliculaEntity usuarioPeliculaEntity){
        return usuarioPeliculaService.updateUsuariosPeliculas(id, usuarioPeliculaEntity);
    }

    @DeleteMapping("/deleteUsuarioPelicula/{id}")
    public void deleteUsuarioPelicula(@PathVariable(value = "id") Integer id){
        usuarioPeliculaService.deleteUsuariosPeliculas(id);
    }

}
