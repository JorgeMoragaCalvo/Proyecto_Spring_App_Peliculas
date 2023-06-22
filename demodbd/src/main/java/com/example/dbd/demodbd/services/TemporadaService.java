package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.TemporadaEntity;
import com.example.dbd.demodbd.repositories.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class TemporadaService {
    private final TemporadaRepository temporadaRepository;

    @Autowired
    public TemporadaService(TemporadaRepository temporadaRepository){
        this.temporadaRepository = temporadaRepository;
    }

    public TemporadaEntity createTemporadas(TemporadaEntity temporadaEntity){
        return temporadaRepository.save(temporadaEntity);
    }

    public Optional<TemporadaEntity> getTemporadasById(Long id){
        return temporadaRepository.findById(id);
    }

    public List<TemporadaEntity> getAllTemporadas(){
        return (List<TemporadaEntity>) temporadaRepository.findAll();
    }

    public TemporadaEntity updateTemporadas(long id, TemporadaEntity temporadaEntity){
        if(!temporadaRepository.existsById(id)) throw new RuntimeException("No existe la temporada");
        temporadaEntity.setIdTemporada(id);
        return temporadaRepository.save(temporadaEntity);
    }

    public void deleteTemporadas(Long id){
        temporadaRepository.deleteById(id);
    }
}
