package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.PeliculaEntity;
import com.example.dbd.demodbd.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {
    private final PeliculaRepository peliculaRepository;

    @Autowired
    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public PeliculaEntity crearPelicula(PeliculaEntity pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public PeliculaEntity obtenerPelicula(long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    public Iterable<PeliculaEntity> obtenerTodasLasPeliculas() {
        return peliculaRepository.findAll();
    }

    public PeliculaEntity actualizaPelicula(long id, PeliculaEntity pelicula) {
        PeliculaEntity peliculaActual = peliculaRepository.findById(id).orElse(null);

        peliculaActual.setTitulo(pelicula.getTitulo());
        peliculaActual.setAnio(pelicula.getAnio());
        peliculaActual.setDescripcion(pelicula.getDescripcion());
        peliculaActual.setDuracion(pelicula.getDuracion());
        peliculaActual.setArchivo(pelicula.getArchivo());
        peliculaActual.setNombre_archivo(pelicula.getNombre_archivo());
        return peliculaRepository.save(peliculaActual);
    }

    public void eliminarPelicula(long id) {
        peliculaRepository.deleteById(id);
    }
}
