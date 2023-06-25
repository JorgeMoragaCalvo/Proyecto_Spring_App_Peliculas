package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.TrabajadorEntity;
import com.example.dbd.demodbd.services.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/trabajadores")
public class TrabajadorController {

    public final TrabajadorService trabajadorService;

    @Autowired
    public TrabajadorController(TrabajadorService trabajadorService){
        this.trabajadorService = trabajadorService;
    }

    @PostMapping("/createTrabajador/")
    public TrabajadorEntity createTrabajadores(@RequestBody TrabajadorEntity trabajadorEntity){
        return trabajadorService.createTrabajadores(trabajadorEntity);
    }

    @GetMapping("/getAllTrabajadores/")
    public List<TrabajadorEntity> getAllTrabajadores(){
        return trabajadorService.getAllTrabajadores();
    }

    @GetMapping("/getTrabajadorById/{id}")
    public Optional<TrabajadorEntity> getTrabajadorById(@PathVariable(value = "id") Integer id){
        Optional<TrabajadorEntity> optionalTrabajadorEntity = trabajadorService.getTrabajadoresById(id);
        if(!optionalTrabajadorEntity.isPresent()) throw new RuntimeException("El trabajador con el id: " + id + " no existe");
        return optionalTrabajadorEntity;
    }

    @PutMapping("/updateTrabajador/{id}")
    public TrabajadorEntity updateTrabajador(@PathVariable(value = "id") Integer id, @RequestBody TrabajadorEntity trabajadorEntity){
        return trabajadorService.updateTrabajadores(id, trabajadorEntity);
    }

    @PutMapping("/assignTrabajadorToPelicula/{id_trabajador}/pelicula/{id_pelicula}")
    public TrabajadorEntity assignTrabajadorToPelicula(
            @PathVariable(value = "id_trabajador") Integer id_trabajador,
            @PathVariable(value = "id_pelicula") Long id_pelicula){
        return trabajadorService.assignTrabajadoresToPeliculas(id_trabajador, id_pelicula);
    }

    @PutMapping("/assignTrabajadorToSerie/{id_trabajador}/serie/{id_serie}")
    public TrabajadorEntity assignTrabajadorToSerie(
            @PathVariable(value = "id_trabajador") Integer id_trabajador,
            @PathVariable(value = "id_serie") Long id_serie){
        return trabajadorService.assignTrabajadoresToSeries(id_trabajador, id_serie);
    }

    @DeleteMapping("/deleteTrabajador/{id}")
    public void deleteTrabajador(@PathVariable(value = "id") Integer id){
        trabajadorService.deleteTrabajadores(id);
    }
}
