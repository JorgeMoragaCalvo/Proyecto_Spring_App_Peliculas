package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.CapituloEntity;
import com.example.dbd.demodbd.repositories.CapituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/capitulo")
public class CapituloController {
    public final CapituloRepository capituloRepository;

    @Autowired
    public CapituloController(CapituloRepository capituloRepository) {
        this.capituloRepository = capituloRepository;
    }

    @PostMapping
    public ResponseEntity<CapituloEntity> crearCapitulo(@RequestBody CapituloEntity capituloEntity) {
         CapituloEntity nuevoCapitulo = capituloRepository.save(capituloEntity);
        return ResponseEntity.ok(nuevoCapitulo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CapituloEntity> obtenerCapitulo(@PathVariable long id){
        CapituloEntity capituloEntity = capituloRepository.findById(id).orElse(null);
        return ResponseEntity.ok(capituloEntity);
    }

    @GetMapping
    public ResponseEntity<Iterable<CapituloEntity>> obtenerTodosLosCapitulos() {
        Iterable<CapituloEntity> capitulos = capituloRepository.findAll();
        return ResponseEntity.ok(capitulos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CapituloEntity> actualizarCapitulo(@PathVariable long id, @RequestBody CapituloEntity capituloEntity) {
        CapituloEntity capituloActualizado = capituloRepository.findById(id).orElse(null);
        capituloActualizado.setTitulo(capituloEntity.getTitulo());
        capituloActualizado.setNumero(capituloEntity.getNumero());
        capituloActualizado.setDuracion(capituloEntity.getDuracion());
        capituloActualizado.setArchivo(capituloEntity.getArchivo());
        capituloActualizado.setNombre_archivo(capituloEntity.getNombre_archivo());
        capituloActualizado.setTemporada(capituloEntity.getTemporada());
        capituloRepository.save(capituloActualizado);
        return ResponseEntity.ok(capituloActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCapitulo(@PathVariable long id) {
        capituloRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
