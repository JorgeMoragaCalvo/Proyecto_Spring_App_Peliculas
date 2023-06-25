package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.UsuarioSerieEntity;
import com.example.dbd.demodbd.repositories.UsuarioSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSerieService {

    public final UsuarioSerieRepository usuarioSerieRepository;

    @Autowired
    public UsuarioSerieService(UsuarioSerieRepository usuarioSerieRepository){
        this.usuarioSerieRepository = usuarioSerieRepository;
    }

    public UsuarioSerieEntity createUsuariosSeries(UsuarioSerieEntity usuarioSerieEntity){
        return usuarioSerieRepository.save(usuarioSerieEntity);
    }

    public List<UsuarioSerieEntity> getAllUsuariosSeries(){
        return (List<UsuarioSerieEntity>)usuarioSerieRepository.findAll();
    }

    public Optional<UsuarioSerieEntity> getAllUsuariosSeriesById(Integer id){
        return usuarioSerieRepository.findById(id);
    }

    public UsuarioSerieEntity updateUsuariosSeries(Integer id, UsuarioSerieEntity usuarioSerieEntity){
        if(!usuarioSerieRepository.existsById(id)) throw new RuntimeException("No existe la Usuario-Serie");
        usuarioSerieEntity.setIdUsuarioSerie(id);
        return usuarioSerieRepository.save(usuarioSerieEntity);
    }

    public void deleteUsuariosSeries(Integer id) {
        usuarioSerieRepository.deleteById(id);
    }
}
