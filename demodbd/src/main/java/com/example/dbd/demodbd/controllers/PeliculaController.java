package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.PeliculaEntity;
import com.example.dbd.demodbd.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    @Autowired
    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @PostMapping("/createPelicula/")
    public PeliculaEntity createPelicula(@RequestBody PeliculaEntity peliculaEntity){
        return peliculaService.createPeliculas(peliculaEntity);
    }

    @GetMapping("/getPeliculas/")
    public List<PeliculaEntity> getPeliculas(){
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/getPeliculaById/{id}")
    public Optional<PeliculaEntity> getPeliculaById(@PathVariable(value = "id") Long id){
        Optional<PeliculaEntity> optionalPeliculaEntity = peliculaService.getAllPeliculasById(id);
        if(!optionalPeliculaEntity.isPresent()) throw new RuntimeException("La Pelicula con el id: " + id + " no existe");
        return optionalPeliculaEntity;
    }

    @GetMapping("/getPeliculaByName/{name}")
    public PeliculaEntity getPeliculaByName(@PathVariable(value = "name") String nombre){
        PeliculaEntity peliculaEntity = peliculaService.findPeliculaByName(nombre);
        if(!peliculaEntity.getTitulo().equals(nombre)) throw new RuntimeException("La Pelicula con el nombre: " + nombre + " no existe");
        return peliculaEntity;
    }

    @PutMapping("/updatePelicula/{id}")
    public PeliculaEntity updatePelicula(@PathVariable(value = "id") Long id, @RequestBody PeliculaEntity peliculaEntity){
        return peliculaService.updatePeliculas(id, peliculaEntity);
    }

    @DeleteMapping("/deletePelicula/{id}")
    public void deletePelicula(@PathVariable(value = "id") Long id){
        peliculaService.deletePeliculas(id);
    }
}
