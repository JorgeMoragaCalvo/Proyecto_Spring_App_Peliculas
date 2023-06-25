package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.UsuarioPeliculaEntity;
import com.example.dbd.demodbd.repositories.UsuarioPeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioPeliculaService {

    public final UsuarioPeliculaRepository usuarioPeliculaRepository;

    @Autowired
    public UsuarioPeliculaService(UsuarioPeliculaRepository usuarioPeliculaRepository){
        this.usuarioPeliculaRepository = usuarioPeliculaRepository;
    }

    public UsuarioPeliculaEntity createUsuariosPeliculas(UsuarioPeliculaEntity usuarioPeliculaEntity){
        return usuarioPeliculaRepository.save(usuarioPeliculaEntity);
    }

    public List<UsuarioPeliculaEntity> getAllUsuariosPeliculas(){
        return (List<UsuarioPeliculaEntity>)usuarioPeliculaRepository.findAll();
    }

    public Optional<UsuarioPeliculaEntity> getAllUsuariosPeliculasById(Integer id){
        return usuarioPeliculaRepository.findById(id);
    }

    public UsuarioPeliculaEntity updateUsuariosPeliculas(Integer id, UsuarioPeliculaEntity usuarioPeliculaEntity){
        if(!usuarioPeliculaRepository.existsById(id)) throw new RuntimeException("No existe la Usuario-Pelicula");
        usuarioPeliculaEntity.setIdUsuarioPelicula(id);
        return usuarioPeliculaRepository.save(usuarioPeliculaEntity);
    }

    public void deleteUsuariosPeliculas(Integer id) {
        usuarioPeliculaRepository.deleteById(id);
    }
}
