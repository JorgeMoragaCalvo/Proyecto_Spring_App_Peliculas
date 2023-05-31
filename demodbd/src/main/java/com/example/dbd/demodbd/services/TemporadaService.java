package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.TemporadaEntity;
import com.example.dbd.demodbd.repositories.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemporadaService {
    private final TemporadaRepository temporadaRepository;

    @Autowired
    public TemporadaService(TemporadaRepository temporadaRepository){
        this.temporadaRepository = temporadaRepository;
    }

    public TemporadaEntity crearTemporada(TemporadaEntity temporada){
        return temporadaRepository.save(temporada);
    }

    public TemporadaEntity obtenerTemporadaPorId(Long id){
        return temporadaRepository.findById(id).orElse(null);
    }

    public Iterable<TemporadaEntity> obtenerTodasLasTemporadas(){
        return temporadaRepository.findAll();
    }

    public TemporadaEntity actualizarTemporada(long id, TemporadaEntity temporada){
        TemporadaEntity temporadaEntity = temporadaRepository.findById(id).orElse(null);
        temporadaEntity.setGlosa(temporada.getGlosa());
        temporadaEntity.setAnio(temporada.getAnio());
        return temporadaRepository.save(temporada);
    }

    public void eliminarTemporada(long id){
        temporadaRepository.deleteById(id);
    }
}
