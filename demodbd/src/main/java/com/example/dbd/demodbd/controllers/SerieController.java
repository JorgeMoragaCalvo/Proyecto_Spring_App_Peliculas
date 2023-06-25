package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.PeliculaEntity;
import com.example.dbd.demodbd.entities.SerieEntity;
import com.example.dbd.demodbd.repositories.SerieRepository;
import com.example.dbd.demodbd.services.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/series")
public class SerieController {
    private final SerieService serieService;

    @Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @PostMapping("/createSerie/")
    public SerieEntity createSerie(@RequestBody SerieEntity serieEntity) {
        return serieService.createSeries(serieEntity);
    }

    @GetMapping("/getSerieById/{id}")
    public Optional<SerieEntity> getSerieById(@PathVariable long id){
        Optional<SerieEntity> optionalSerieEntity = serieService.getAllSeriesById(id);
        if(!optionalSerieEntity.isPresent()) throw new RuntimeException("La serie con el id: " + id + " no existe");
        return optionalSerieEntity;
    }

    @GetMapping("/getSerie/")
    public List<SerieEntity> getSerie() {
        return serieService.getAllSeries();
    }

    @PutMapping("/updateSerie/{id}")
    public SerieEntity updateSerie(@PathVariable Long id, @RequestBody SerieEntity serieEntity) {
        return serieService.updateSeries(id, serieEntity);
    }

    @DeleteMapping("/deleteSerie/{id}")
    public void deleteSerie(@PathVariable long id) {
        serieService.deleteSeries(id);
    }

    @GetMapping("/rankingSeries/")
    public List<SerieEntity> rankingSeries(){
        return serieService.getRankingSeriesMasValoradas();
    }

}
