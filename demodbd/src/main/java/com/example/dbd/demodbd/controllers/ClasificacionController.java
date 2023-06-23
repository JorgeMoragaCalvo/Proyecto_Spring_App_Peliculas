package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.ClasificacionEntity;
import com.example.dbd.demodbd.entities.PeliculaEntity;
import com.example.dbd.demodbd.services.ClasificacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/clasificaciones")
public class ClasificacionController {

    public final ClasificacionService clasificacionService;
    public ClasificacionController(ClasificacionService clasificacionService){
        this.clasificacionService = clasificacionService;
    }

    @PostMapping("/createClasificacion/")
    public ClasificacionEntity createClasificacion(@RequestBody ClasificacionEntity clasificacionEntity){
        return clasificacionService.createClasificaciones(clasificacionEntity);
    }

    @GetMapping("/getClasificaciones/")
    public List<ClasificacionEntity> getClasificaciones(){
        return clasificacionService.getAllClasificaciones();
    }

    @GetMapping("/getClasificacionById/{id}")
    public Optional<ClasificacionEntity> getClasificacionById(@PathVariable(value = "id") Long id){
        Optional<ClasificacionEntity> optionalClasificacionEntity = clasificacionService.getAllClasificacionesById(id);
        if(!optionalClasificacionEntity.isPresent()) throw new RuntimeException("La Clasificacion con el id: " + id + " no existe");
        return optionalClasificacionEntity;
    }

    @PutMapping("/updateClasificacion/{id}")
    public ClasificacionEntity updateClasificacion(@PathVariable(value = "id") Long id, @RequestBody ClasificacionEntity clasificacionEntity){
        return clasificacionService.updateClasificaciones(id, clasificacionEntity);
    }

    @DeleteMapping("/deleteClasificacion/{id}")
    public void deleteClasificacion(@PathVariable(value = "id") Long id){
        clasificacionService.deleteClasificaciones(id);
    }

}
