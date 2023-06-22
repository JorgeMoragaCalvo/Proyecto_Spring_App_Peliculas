package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.ClasificacionEntity;
import com.example.dbd.demodbd.repositories.ClasificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasificacionService {

    public final ClasificacionRepository clasificacionRepository;
    public ClasificacionService(ClasificacionRepository clasificacionRepository){
        this.clasificacionRepository = clasificacionRepository;
    }

    public ClasificacionEntity createClasificaciones(ClasificacionEntity clasificacionEntity){
        return clasificacionRepository.save(clasificacionEntity);
    }

    public List<ClasificacionEntity> getAllClasificaciones(){
        return (List<ClasificacionEntity>)clasificacionRepository.findAll();
    }

    public Optional<ClasificacionEntity> getAllClasificacionesById(Long id){
        return clasificacionRepository.findById(id);
    }

    public ClasificacionEntity updateClasificaciones(Long id, ClasificacionEntity clasificacionEntity){
        if(!clasificacionRepository.existsById(id)) throw new RuntimeException("No existe la clasficacion");
        clasificacionEntity.setIdClasificacion(id);
        return clasificacionRepository.save(clasificacionEntity);
    }

    public void deleteClasificaciones(Long id) {
        clasificacionRepository.deleteById(id);
    }
}
