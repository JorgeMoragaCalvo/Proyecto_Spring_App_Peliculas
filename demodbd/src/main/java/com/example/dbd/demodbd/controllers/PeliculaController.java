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

    @PostMapping("/")
    public PeliculaEntity createPelicula(@RequestBody PeliculaEntity peliculaEntity){
        return peliculaService.createPeliculas(peliculaEntity);
    }

    @GetMapping("/")
    public List<PeliculaEntity> getPeliculas(){
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/{id}")
    public Optional<PeliculaEntity> getPeliculaById(@PathVariable(value = "id") Long id){
        Optional<PeliculaEntity> optionalPeliculaEntity = peliculaService.getAllPeliculasById(id);
        if(!optionalPeliculaEntity.isPresent()) throw new RuntimeException("La Pelicula con el id: " + id + " no existe");
        return optionalPeliculaEntity;
    }

    @PutMapping("/{id}")
    public PeliculaEntity updatePelicula(@PathVariable(value = "id") Long id, @RequestBody PeliculaEntity peliculaEntity){
        return peliculaService.updatePeliculas(id, peliculaEntity);
    }

    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable(value = "id") Long id){
        peliculaService.deletePeliculas(id);
    }
}
