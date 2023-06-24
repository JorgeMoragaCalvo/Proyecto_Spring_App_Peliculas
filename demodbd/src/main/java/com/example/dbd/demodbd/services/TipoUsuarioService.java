package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.ClasificacionEntity;
import com.example.dbd.demodbd.entities.TipoUsuarioEntity;
import com.example.dbd.demodbd.repositories.ClasificacionRepository;
import com.example.dbd.demodbd.repositories.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService {

    public final TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository){
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public TipoUsuarioEntity createTiposUsuarios(TipoUsuarioEntity tipoUsuarioEntity){
        return tipoUsuarioRepository.save(tipoUsuarioEntity);
    }

    public List<TipoUsuarioEntity> getAllTiposUsuarios(){
        return (List<TipoUsuarioEntity>)tipoUsuarioRepository.findAll();
    }

    public Optional<TipoUsuarioEntity> getAllTiposUsuariosById(Integer id){
        return tipoUsuarioRepository.findById(id);
    }

    public TipoUsuarioEntity updateTiposUsuarios(Integer id, TipoUsuarioEntity tipoUsuarioEntity){
        if(!tipoUsuarioRepository.existsById(id)) throw new RuntimeException("No existe el tipo usuario");
        tipoUsuarioEntity.setIdTipoUsuario(id);
        return tipoUsuarioRepository.save(tipoUsuarioEntity);
    }

    public void deleteTiposUsuarios(Integer id) {
        tipoUsuarioRepository.deleteById(id);
    }
}
