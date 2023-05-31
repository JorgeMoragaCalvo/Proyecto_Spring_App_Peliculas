package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.CapituloEntity;
import com.example.dbd.demodbd.repositories.CapituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapituloService {
    private final CapituloRepository capituloRepository;

    @Autowired
    public CapituloService(CapituloRepository capituloRepository){
        this.capituloRepository = capituloRepository;
    }

    public CapituloEntity crearCapitulo(CapituloEntity capitulo){
        return capituloRepository.save(capitulo);
    }

    public CapituloEntity obtenerCapituloPorId(long id){
        return capituloRepository.findById(id).orElse(null);
    }

    public Iterable<CapituloEntity> obtenerTodosLosCapitulos(){
        return capituloRepository.findAll();
    }

    public CapituloEntity actualizarCapitulo(long id, CapituloEntity capitulo){
        CapituloEntity capituloEntity = capituloRepository.findById(id).orElse(null);
        capituloEntity.setTitulo(capitulo.getTitulo());
        capituloEntity.setNumero(capitulo.getNumero());
        capituloEntity.setDuracion(capitulo.getDuracion());
        capituloEntity.setArchivo(capitulo.getArchivo());
        capituloEntity.setNombre_archivo(capitulo.getNombre_archivo());
        return capituloRepository.save(capitulo);
    }

    public void eliminarCapitulo(long id){
        capituloRepository.deleteById(id);
    }
}
