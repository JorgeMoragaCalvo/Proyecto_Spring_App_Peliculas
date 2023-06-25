package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.LaborEntity;
import com.example.dbd.demodbd.services.LaborService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/labores")
public class LaborController {

    public final LaborService laborService;
    public LaborController(LaborService laborService){
        this.laborService = laborService;
    }

    @PostMapping("/createLabor/")
    public LaborEntity createLabor(@RequestBody LaborEntity laborEntity){
        return laborService.createLabores(laborEntity);
    }

    @GetMapping("/getLabores/")
    public List<LaborEntity> getLabores(){
        return laborService.getAllLabores();
    }

    @GetMapping("/getLaborById/{id}")
    public Optional<LaborEntity> getLaborById(@PathVariable(value = "id") Integer id){
        Optional<LaborEntity> optionalLaborEntity = laborService.getAllLaboresById(id);
        if(!optionalLaborEntity.isPresent()) throw new RuntimeException("La Labor con el id: " + id + " no existe");
        return optionalLaborEntity;
    }

    @PutMapping("/updateLabor/{id}")
    public LaborEntity updateLabor(@PathVariable(value = "id") Integer id, @RequestBody LaborEntity laborEntity){
        return laborService.updateLabores(id, laborEntity);
    }

    @DeleteMapping("/deleteLabor/{id}")
    public void deleteLabor(@PathVariable(value = "id") Integer id){
        laborService.deleteLabores(id);
    }

}
