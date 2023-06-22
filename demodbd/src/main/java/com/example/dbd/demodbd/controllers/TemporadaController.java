package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.TemporadaEntity;
import com.example.dbd.demodbd.services.TemporadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.dbd.demodbd.repositories.TemporadaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/temporadas")
public class TemporadaController {
    private final TemporadaService temporadaService;

    @Autowired
    public TemporadaController(TemporadaService temporadaService) {
        this.temporadaService = temporadaService;
    }

    @PostMapping("/")
    public TemporadaEntity createTemporada(@RequestBody TemporadaEntity temporadaEntity) {
        return temporadaService.createTemporadas(temporadaEntity);
    }

    @GetMapping("/{id}")
    public Optional<TemporadaEntity> getTemporadaById(@PathVariable long id){
        Optional<TemporadaEntity> optionalTemporadaEntity = temporadaService.getTemporadasById(id);
        if(!optionalTemporadaEntity.isPresent()) throw new RuntimeException("La Temporada con el id: " + id + " no existe");
        return optionalTemporadaEntity;
    }

    @GetMapping("/")
    public List<TemporadaEntity> getTemporadas(){
        return temporadaService.getAllTemporadas();
    }

    @PutMapping("/{id}")
    public TemporadaEntity updateTemporada(@PathVariable(value = "id") Long id, @RequestBody TemporadaEntity temporadaEntity) {
        return temporadaService.updateTemporadas(id, temporadaEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteTemporada(@PathVariable(value = "id") Long id) {
        temporadaService.deleteTemporadas(id);
    }

}
