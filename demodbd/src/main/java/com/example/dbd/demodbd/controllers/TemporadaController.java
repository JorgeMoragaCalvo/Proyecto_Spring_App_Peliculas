package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.TemporadaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.dbd.demodbd.repositories.TemporadaRepository;

import java.util.List;

@RestController
@RequestMapping("/temporada")
public class TemporadaController {
    private final TemporadaRepository temporadaRepository;

    @Autowired
    public TemporadaController(TemporadaRepository temporadaRepository) {
        this.temporadaRepository = temporadaRepository;
    }

    @PostMapping
    public ResponseEntity<TemporadaEntity> crearTemporada(@RequestBody TemporadaEntity temporadaEntity) {
        TemporadaEntity nuevaTemporada = temporadaRepository.save(temporadaEntity);
        return ResponseEntity.ok(nuevaTemporada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemporadaEntity> obtenerTemporada(@PathVariable long id){
        TemporadaEntity temporadaEntity = temporadaRepository.findById(id).orElse(null);
        return ResponseEntity.ok(temporadaEntity);
    }

    @GetMapping
    public ResponseEntity<Iterable<TemporadaEntity>> obtenerTodasLasTemporadas(){
        Iterable<TemporadaEntity> temporadas = temporadaRepository.findAll();
        return ResponseEntity.ok(temporadas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TemporadaEntity> actualizarTemporada(@PathVariable long id, @RequestBody TemporadaEntity temporadaEntity) {
        TemporadaEntity temporadaActualizada = temporadaRepository.findById(id).orElse(null);
        temporadaActualizada.setGlosa(temporadaEntity.getGlosa());
        temporadaActualizada.setAnio(temporadaEntity.getAnio());
        temporadaRepository.save(temporadaActualizada);
        return ResponseEntity.ok(temporadaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TemporadaEntity> eliminarTemporada(@PathVariable long id) {
        temporadaRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
