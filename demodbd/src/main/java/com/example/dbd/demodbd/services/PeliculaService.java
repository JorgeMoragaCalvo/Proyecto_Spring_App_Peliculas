package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.PeliculaEntity;
import com.example.dbd.demodbd.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {
    private final PeliculaRepository peliculaRepository;

    @Autowired
    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public PeliculaEntity createPeliculas(PeliculaEntity peliculaEntity){
        return peliculaRepository.save(peliculaEntity);
    }

    public List<PeliculaEntity> getAllPeliculas(){
        return (List<PeliculaEntity>)peliculaRepository.findAll();
    }

    public Optional<PeliculaEntity> getAllPeliculasById(Long id){
        return peliculaRepository.findById(id);
    }

    public PeliculaEntity findPeliculaByName(String name) {
        List<PeliculaEntity> Allpeliculas = (List<PeliculaEntity>) peliculaRepository.findAll();
        PeliculaEntity peliculaEntity = null;
        for (PeliculaEntity pelicula : Allpeliculas) {
            if (pelicula.getTitulo().equals(name)) {
                peliculaEntity = pelicula;
            }
        }
        return peliculaEntity;
    }


    public PeliculaEntity updatePeliculas(Long id, PeliculaEntity peliculaEntity){
        if(!peliculaRepository.existsById(id)) throw new RuntimeException("No existe la pelicula");
        peliculaEntity.setId_pelicula(id);
        return peliculaRepository.save(peliculaEntity);
    }

    public void deletePeliculas(Long id){
        peliculaRepository.deleteById(id);
    }
}
