package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.ClasificacionEntity;
import com.example.dbd.demodbd.entities.UsuarioEntity;
import com.example.dbd.demodbd.repositories.ClasificacionRepository;
import com.example.dbd.demodbd.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    public final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioEntity createUsuarios(UsuarioEntity usuarioEntity){
        return usuarioRepository.save(usuarioEntity);
    }

    public List<UsuarioEntity> getAllUsuarios(){
        return (List<UsuarioEntity>)usuarioRepository.findAll();
    }

    public Optional<UsuarioEntity> getAllUsuariosById(Long id){
        return usuarioRepository.findById(id);
    }

    public UsuarioEntity updateUsuarios(Long id, UsuarioEntity usuarioEntity){
        if(!usuarioRepository.existsById(id)) throw new RuntimeException("No existe la clasficacion");
        usuarioEntity.setIdUsuario(id);
        return usuarioRepository.save(usuarioEntity);
    }

    public void deleteUsuarios(Long id) {
        usuarioRepository.deleteById(id);
    }

}
