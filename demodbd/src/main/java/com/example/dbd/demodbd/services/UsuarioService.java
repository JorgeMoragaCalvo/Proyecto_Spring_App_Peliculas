package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.*;
import com.example.dbd.demodbd.repositories.SuscripcionRepository;
import com.example.dbd.demodbd.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private SuscripcionRepository suscripcionRepository;
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
        if(!usuarioRepository.existsById(id)) throw new RuntimeException("No existe el usuario");
        usuarioEntity.setIdUsuario(id);
        return usuarioRepository.save(usuarioEntity);
    }

    public void deleteUsuarios(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioEntity assignUsuarioToSuscripcion(Long id_usuario, Long id_suscripcion){
        List<SuscripcionEntity> suscripcion = null;
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id_usuario).get();
        SuscripcionEntity suscripcionEntity = suscripcionRepository.findById(id_suscripcion).get();
        suscripcion = usuarioEntity.getSuscripcionEntities();
        suscripcion.add(suscripcionEntity);
        return usuarioRepository.save(usuarioEntity);
    }

    public String login(String nombreUsuario, String contrasena){
        List<UsuarioEntity> usuarios = (List<UsuarioEntity>)usuarioRepository.findAll();
        for (UsuarioEntity usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                if(usuario.getContrasena().equals(contrasena))
                    return "Login exitoso";
                else
                    return "Contraseña incorrecta";
            }
        }
        return "Usuario no encontrado";
    }
}
