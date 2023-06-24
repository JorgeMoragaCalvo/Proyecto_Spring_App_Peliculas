package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.SuscripcionEntity;
import com.example.dbd.demodbd.repositories.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuscripcionService {

    public final SuscripcionRepository suscripcionRepository;

    @Autowired
    public SuscripcionService(SuscripcionRepository suscripcionRepository){
        this.suscripcionRepository = suscripcionRepository;
    }

    public SuscripcionEntity createSuscripciones(SuscripcionEntity suscripcionEntity){
        return suscripcionRepository.save(suscripcionEntity);
    }

    public List<SuscripcionEntity> getAllSuscripciones(){
        return (List<SuscripcionEntity>)suscripcionRepository.findAll();
    }

    public Optional<SuscripcionEntity> getAllSuscripcionesById(Long id){
        return suscripcionRepository.findById(id);
    }

    public SuscripcionEntity updateSuscripciones(Long id, SuscripcionEntity suscripcionEntity){
        if(!suscripcionRepository.existsById(id)) throw new RuntimeException("No existe la suscripcion");
        suscripcionEntity.setIdSuscripcion(id);
        return suscripcionRepository.save(suscripcionEntity);
    }

    public void deleteSuscripciones(Long id) {
        suscripcionRepository.deleteById(id);
    }

}
