package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.SerieEntity;
import com.example.dbd.demodbd.repositories.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService{
    private final SerieRepository serieRepository;

    @Autowired
    public SerieService(SerieRepository serieRepository){
        this.serieRepository = serieRepository;
    }

    public SerieEntity createSeries(SerieEntity serieEntity){
        return serieRepository.save(serieEntity);
    }

    public Optional<SerieEntity> getAllSeriesById(Long id){
        return serieRepository.findById(id);
    }

    public List<SerieEntity> getAllSeries(){
        return (List<SerieEntity>) serieRepository.findAll();
    }

    public SerieEntity updateSeries(long id, SerieEntity serieEntity){
        if(!serieRepository.existsById(id)) throw new RuntimeException("No existe la serie");
        serieEntity.setIdSerie(id);
        return serieRepository.save(serieEntity);
    }

    public void deleteSeries(long id){
        serieRepository.deleteById(id);
    }
}
