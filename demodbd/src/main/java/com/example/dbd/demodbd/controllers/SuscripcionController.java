package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.SuscripcionEntity;
import com.example.dbd.demodbd.services.SuscripcionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/suscripcion")
public class SuscripcionController {
    public final SuscripcionService suscripcionService;
    public SuscripcionController(SuscripcionService suscripcionService){
        this.suscripcionService = suscripcionService;
    }

    @PostMapping("/createSuscripcion/")
    public SuscripcionEntity createSuscripcion(@RequestBody SuscripcionEntity suscripcionEntity){
        return suscripcionService.createSuscripciones(suscripcionEntity);
    }

    @GetMapping("/getSuscripciones/")
    public List<SuscripcionEntity> getSuscripciones(){
        return suscripcionService.getAllSuscripciones();
    }

    @GetMapping("/getSuscripcionById/{id}")
    public Optional<SuscripcionEntity> getSuscripcionById(@PathVariable(value = "id") Long id){
        Optional<SuscripcionEntity> optionalSuscripcionEntity = suscripcionService.getAllSuscripcionesById(id);
        if(!optionalSuscripcionEntity.isPresent()) throw new RuntimeException("La Suscripcion con el id: " + id + " no existe");
        return optionalSuscripcionEntity;
    }

    @PutMapping("/updateSuscripcion/{id}")
    public SuscripcionEntity updateSuscripcion(@PathVariable(value = "id") Long id, @RequestBody SuscripcionEntity suscripcionEntity){
        return suscripcionService.updateSuscripciones(id, suscripcionEntity);
    }

    @DeleteMapping("/deleteSuscripcion/{id}")
    public void deleteSuscripcion(@PathVariable(value = "id") Long id){
        suscripcionService.deleteSuscripciones(id);
    }
}
