package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.UsuarioSuscripcionEntity;
import com.example.dbd.demodbd.entities.UsuarioSuscripcionId;
import com.example.dbd.demodbd.repositories.UsuarioSuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSuscripcionService {

    public final UsuarioSuscripcionRepository usuarioSuscripcionRepository;

    @Autowired
    public UsuarioSuscripcionService(UsuarioSuscripcionRepository usuarioSuscripcionRepository){
        this.usuarioSuscripcionRepository = usuarioSuscripcionRepository;
    }

    public UsuarioSuscripcionEntity createUsuariosSuscripcion(UsuarioSuscripcionEntity usuarioSuscripcionEntity){
        return usuarioSuscripcionRepository.save(usuarioSuscripcionEntity);
    }

    public List<UsuarioSuscripcionEntity> getAllUsuariosSuscripcion(){
        return (List<UsuarioSuscripcionEntity>)usuarioSuscripcionRepository.findAll();
    }

    public Optional<UsuarioSuscripcionEntity> getAllUsuariosSuscripcionById(UsuarioSuscripcionId id){
        return usuarioSuscripcionRepository.findById(id);
    }

    public UsuarioSuscripcionEntity updateUsuariosSuscripcion(UsuarioSuscripcionId id, UsuarioSuscripcionEntity usuarioSuscripcionEntity){
        if(!usuarioSuscripcionRepository.existsById(id)) throw new RuntimeException("No existe el usuario-suscripcion");
        usuarioSuscripcionEntity.setId(id);
        return usuarioSuscripcionRepository.save(usuarioSuscripcionEntity);
    }

    public void deleteUsuariosSuscripcion(UsuarioSuscripcionId id) {
        usuarioSuscripcionRepository.deleteById(id);
    }
}
