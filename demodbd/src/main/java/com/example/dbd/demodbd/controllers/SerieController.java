package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.SerieEntity;
import com.example.dbd.demodbd.repositories.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/serie")
public class SerieController {
    private final SerieRepository serieRepository;

    @Autowired
    public SerieController(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @PostMapping
    public ResponseEntity<SerieEntity> crearSerie(@RequestBody SerieEntity serieEntity) {
        SerieEntity nuevaSerie = serieRepository.save(serieEntity);
        return ResponseEntity.ok(nuevaSerie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SerieEntity> obtenerSerie(@PathVariable long id){
        SerieEntity serieEntity = serieRepository.findById(id).orElse(null);
        return ResponseEntity.ok(serieEntity);
    }

    @GetMapping
    public ResponseEntity<Iterable<SerieEntity>> obtenerTodasLasSeries() {
        Iterable<SerieEntity> series = serieRepository.findAll();
        return ResponseEntity.ok(series);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SerieEntity> actualizarSerie(@PathVariable long id, @RequestBody SerieEntity serieEntity) {
        SerieEntity serieActualizada = serieRepository.findById(id).orElse(null);
        serieActualizada.setTitulo(serieEntity.getTitulo());
        serieActualizada.setAnio(serieEntity.getAnio());
        serieActualizada.setDescripcion(serieEntity.getDescripcion());
        serieRepository.save(serieActualizada);
        return ResponseEntity.ok(serieActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSerie(@PathVariable long id) {
        serieRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
