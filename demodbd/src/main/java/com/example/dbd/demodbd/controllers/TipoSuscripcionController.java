package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.TipoSuscripcionEntity;
import com.example.dbd.demodbd.services.TipoSuscripcionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/tipoSuscripcion")
public class TipoSuscripcionController {

    public final TipoSuscripcionService tipoSuscripcionService;
    public TipoSuscripcionController(TipoSuscripcionService tipoSuscripcionService){
        this.tipoSuscripcionService = tipoSuscripcionService;
    }

    @PostMapping("/createTipoSuscripcion/")
    public TipoSuscripcionEntity createTipoSuscripcion(@RequestBody TipoSuscripcionEntity tipoSuscripcionEntity){
        return tipoSuscripcionService.createTiposSuscripciones(tipoSuscripcionEntity);
    }

    @GetMapping("/getTiposSuscripciones/")
    public List<TipoSuscripcionEntity> getTiposSuscripciones(){
        return tipoSuscripcionService.getAllTiposSuscripciones();
    }

    @GetMapping("/getTipoSuscripcionById/{id}")
    public Optional<TipoSuscripcionEntity> getTipoSuscripcionById(@PathVariable(value = "id") Integer id){
        Optional<TipoSuscripcionEntity> optionalTipoSuscripcionEntity = tipoSuscripcionService.getAllTiposSuscripcionesById(id);
        if(!optionalTipoSuscripcionEntity.isPresent()) throw new RuntimeException("El Tipo Suscripcion con el id: " + id + " no existe");
        return optionalTipoSuscripcionEntity;
    }

    @PutMapping("/updateTipoSuscripcion/{id}")
    public TipoSuscripcionEntity updateTipoSuscripcion(@PathVariable(value = "id") Integer id, @RequestBody TipoSuscripcionEntity tipoSuscripcionEntity){
        return tipoSuscripcionService.updateTiposSuscripciones(id, tipoSuscripcionEntity);
    }

    @DeleteMapping("/deleteTipoSuscripcion/{id}")
    public void deleteTipoSuscripcion(@PathVariable(value = "id") Integer id){
        tipoSuscripcionService.deleteTiposSuscripciones(id);
    }

}
