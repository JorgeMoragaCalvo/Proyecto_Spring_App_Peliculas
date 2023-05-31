package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.UsuarioEntity;
import com.example.dbd.demodbd.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioEntity saveUsuario(UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
    }

    public Iterable<UsuarioEntity> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity getUsuarioById(long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe el usuario"));
    }

//    public void deleteUsuarioById(long id) {
//        usuarioRepository.deleteById(id);
//    }

    public void deleteUsuario(long id) {
        usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe el usuario"));
        usuarioRepository.deleteById(id);
    }

}
