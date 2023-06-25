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

    @GetMapping("/getPeliculasByCategory/{category}")
    public List<PeliculaEntity> getPeliculasByCategory(@PathVariable(value = "category") String categoria){
        List<PeliculaEntity> peliculas = peliculaService.findPeliculaByCategory(categoria);
        if(peliculas.isEmpty()) throw new RuntimeException("La Categoria con el nombre " + categoria + " no tiene peliculas");
        return peliculas;
    }

    @GetMapping("/getPeliculasByProducer/{producer}")
    public List<PeliculaEntity> getPeliculasByProducer(@PathVariable(value = "producer") String productora){
        List<PeliculaEntity> peliculas = peliculaService.findPeliculaByProducer(productora);
        if(peliculas.isEmpty()) throw new RuntimeException("La Productora con el nombre " + productora + " no tiene peliculas");
        return peliculas;
    }

    @GetMapping("/getPeliculaByDirectorName/{name}")
    public List<PeliculaEntity> getPeliculaByDirectorName(@PathVariable(value = "name") String nombre){
        List<PeliculaEntity> peliculas = peliculaService.findPeliculaByDirectorName(nombre);
        if(peliculas.isEmpty()) throw new RuntimeException("La Director con el nombre: " + nombre + " no tiene peliculas");
        return peliculas;
    }

    @GetMapping("/rankingPeliculas/")
    public List<PeliculaEntity> rankingPeliculas(){
        return peliculaService.getRankingPeliculasMasValoradas();
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
