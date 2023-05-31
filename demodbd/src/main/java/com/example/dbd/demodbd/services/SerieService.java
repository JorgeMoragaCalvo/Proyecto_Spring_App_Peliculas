package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.SerieEntity;
import com.example.dbd.demodbd.repositories.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService{
    private final SerieRepository serieRepository;

    @Autowired
    public SerieService(SerieRepository serieRepository){
        this.serieRepository = serieRepository;
    }

    public SerieEntity crearSeries(SerieEntity serie){
        return serieRepository.save(serie);
    }

    public SerieEntity obtenerSeriePorId(Long id){
        return serieRepository.findById(id).orElse(null);
    }

    public Iterable<SerieEntity> obtenerTodasLasSeries(){
        return serieRepository.findAll();
    }

    public SerieEntity actualizarSerie(long id, SerieEntity serie){
        SerieEntity serieEntity = serieRepository.findById(id).orElse(null);
        serieEntity.setTitulo(serie.getTitulo());
        serieEntity.setDescripcion(serie.getDescripcion());
        serieEntity.setAnio(serie.getAnio());
        return serieRepository.save(serie);
    }

    public void eliminarSerie(long id){
        serieRepository.deleteById(id);
    }
}
