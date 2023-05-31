package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.PeliculaEntity;
import com.example.dbd.demodbd.repositories.PeliculaRepository;
import com.example.dbd.demodbd.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pelicula")
public class PeliculaController {
    private final PeliculaRepository peliculaRepository;

    @Autowired
    public PeliculaController(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @PostMapping
    public ResponseEntity<PeliculaEntity> crearPelicula(@RequestBody PeliculaEntity peliculaEntity) {
        PeliculaEntity nuevaPelicula = peliculaRepository.save(peliculaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPelicula);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PeliculaEntity>> obtenerPeliculaById(@PathVariable long id) {
        PeliculaEntity peliculaEntity = peliculaRepository.findById(id).orElse(null);
        return ResponseEntity.ok((List<PeliculaEntity>) peliculaEntity);
    }

    @GetMapping
    public ResponseEntity<PeliculaEntity> obtenerTodasLasPeliculas() {
        Iterable<PeliculaEntity> peliculas = peliculaRepository.findAll();
        return ResponseEntity.ok((PeliculaEntity) peliculas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaEntity> actualizarPelicula(@PathVariable long id, @RequestBody PeliculaEntity peliculaEntity) {
        PeliculaEntity peliculaActualizada = peliculaRepository.findById(id).orElse(null);
        peliculaActualizada.setTitulo(peliculaEntity.getTitulo());
        peliculaActualizada.setAnio(peliculaEntity.getAnio());
        peliculaActualizada.setDescripcion(peliculaEntity.getDescripcion());
        peliculaActualizada.setDuracion(peliculaEntity.getDuracion());
        peliculaActualizada.setArchivo(peliculaEntity.getArchivo());
        peliculaActualizada.setNombre_archivo(peliculaEntity.getNombre_archivo());
        peliculaRepository.save(peliculaActualizada);
        return ResponseEntity.ok(peliculaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable long id) {
        peliculaRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
