package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.CapituloEntity;
import com.example.dbd.demodbd.repositories.CapituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapituloService {
    private final CapituloRepository capituloRepository;

    @Autowired
    public CapituloService(CapituloRepository capituloRepository){
        this.capituloRepository = capituloRepository;
    }

    public CapituloEntity createCapitulos(CapituloEntity capituloEntity){
        return capituloRepository.save(capituloEntity);
    }

    public List<CapituloEntity> getAllCapitulos(){
        return (List<CapituloEntity>)capituloRepository.findAll();
    }

    public Optional<CapituloEntity> getAllCapitulosById(Long id){
        return capituloRepository.findById(id);
    }

    public CapituloEntity updateCapitulos(Long id, CapituloEntity capituloEntity){
        if(!capituloRepository.existsById(id)) throw new RuntimeException("No existe el capitulo");
        capituloEntity.setIdCapitulo(id);
        return capituloRepository.save(capituloEntity);
    }

    public void deleteCapitulos(Long id) {
        capituloRepository.deleteById(id);
    }

}
