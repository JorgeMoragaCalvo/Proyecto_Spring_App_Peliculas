package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.SerieEntity;
import com.example.dbd.demodbd.entities.TrabajadorEntity;
import com.example.dbd.demodbd.entities.PeliculaEntity;
import com.example.dbd.demodbd.repositories.SerieRepository;
import com.example.dbd.demodbd.repositories.TrabajadorRepository;
import com.example.dbd.demodbd.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorService {

    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private SerieRepository serieRepository;
    public final TrabajadorRepository trabajadorRepository;

    @Autowired
    public TrabajadorService(TrabajadorRepository trabajadorRepository){
        this.trabajadorRepository = trabajadorRepository;
    }

    public TrabajadorEntity createTrabajadores(TrabajadorEntity trabajadorEntity){
        return trabajadorRepository.save(trabajadorEntity);
    }

    public List<TrabajadorEntity> getAllTrabajadores(){
        return (List<TrabajadorEntity>)trabajadorRepository.findAll();
    }

    public Optional<TrabajadorEntity> getTrabajadoresById(Integer id){
        return trabajadorRepository.findById(id);
    }

    public TrabajadorEntity updateTrabajadores(Integer id, TrabajadorEntity trabajadorEntity){
        if(!trabajadorRepository.existsById(id)) throw new RuntimeException("No existe el trabajador");
        trabajadorEntity.setIdTrabajador(id);
        return trabajadorRepository.save(trabajadorEntity);
    }

    public TrabajadorEntity assignTrabajadoresToPeliculas(Integer id_trabajador, Long id_pelicula){
        List<PeliculaEntity> peliculas;
        TrabajadorEntity trabajadorEntity = trabajadorRepository.findById(id_trabajador).get();
        PeliculaEntity peliculaEntity = peliculaRepository.findById(id_pelicula).get();
        peliculas = trabajadorEntity.getPeliculaEntities();
        peliculas.add(peliculaEntity);
        return trabajadorRepository.save(trabajadorEntity);
    }

    public TrabajadorEntity assignTrabajadoresToSeries(Integer id_trabajador, Long id_serie){
        List<SerieEntity> series;
        TrabajadorEntity trabajadorEntity = trabajadorRepository.findById(id_trabajador).get();
        SerieEntity serieEntity = serieRepository.findById(id_serie).get();
        series = trabajadorEntity.getSerieEntities();
        series.add(serieEntity);
        return trabajadorRepository.save(trabajadorEntity);
    }

    public void deleteTrabajadores(Integer id) {
        trabajadorRepository.deleteById(id);
    }
}
