package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.CapituloEntity;
import com.example.dbd.demodbd.services.CapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/capitulos")
public class CapituloController {
    public final CapituloService capituloService;

    @Autowired
    public CapituloController(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    @PostMapping("/createCapitulo/")
    public CapituloEntity createCapitulo(@RequestBody CapituloEntity capituloEntity){
        return capituloService.createCapitulos(capituloEntity);
    }

    @GetMapping("/getCapitulos/")
    public List<CapituloEntity> getCapitulos(){
        return capituloService.getAllCapitulos();
    }

    @GetMapping("/getCapituloById/{id}")
    public Optional<CapituloEntity> getCapituloById(@PathVariable(value = "id") Long id){
        Optional<CapituloEntity> optionalCapituloEntity = capituloService.getAllCapitulosById(id);
        if(!optionalCapituloEntity.isPresent()) throw new RuntimeException("El Capitulo con el id: " + id + " no existe");
        return optionalCapituloEntity;
    }

    @PutMapping("/updateCapitulo/{id}")
    public CapituloEntity updateCapitulo(@PathVariable(value = "id") Long id, @RequestBody CapituloEntity capituloEntity){
        return capituloService.updateCapitulos(id, capituloEntity);
    }

    @DeleteMapping("/deleteCapitulo/{id}")
    public void deleteCapitulo(@PathVariable(value = "id") Long id){
        capituloService.deleteCapitulos(id);
    }

}
