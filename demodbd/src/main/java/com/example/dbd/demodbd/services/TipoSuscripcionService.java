package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.TipoSuscripcionEntity;
import com.example.dbd.demodbd.repositories.TipoSuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoSuscripcionService {

    public final TipoSuscripcionRepository tipoSuscripcionRepository;

    @Autowired
    public TipoSuscripcionService(TipoSuscripcionRepository tipoSuscripcionRepository){
        this.tipoSuscripcionRepository = tipoSuscripcionRepository;
    }

    public TipoSuscripcionEntity createTiposSuscripciones(TipoSuscripcionEntity tipoSuscripcionEntity){
        return tipoSuscripcionRepository.save(tipoSuscripcionEntity);
    }

    public List<TipoSuscripcionEntity> getAllTiposSuscripciones(){
        return (List<TipoSuscripcionEntity>)tipoSuscripcionRepository.findAll();
    }

    public Optional<TipoSuscripcionEntity> getAllTiposSuscripcionesById(Integer id){
        return tipoSuscripcionRepository.findById(id);
    }

    public TipoSuscripcionEntity updateTiposSuscripciones(Integer id, TipoSuscripcionEntity tipoSuscripcionEntity){
        if(!tipoSuscripcionRepository.existsById(id)) throw new RuntimeException("No existe el tipo suscripcion");
        tipoSuscripcionEntity.setIdTipoSuscripcion(id);
        return tipoSuscripcionRepository.save(tipoSuscripcionEntity);
    }

    public void deleteTiposSuscripciones(Integer id) {
        tipoSuscripcionRepository.deleteById(id);
    }
}
