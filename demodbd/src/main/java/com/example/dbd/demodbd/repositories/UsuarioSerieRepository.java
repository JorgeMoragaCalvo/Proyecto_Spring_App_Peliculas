package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.ClasificacionEntity;
import com.example.dbd.demodbd.entities.UsuarioSerieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioSerieRepository extends CrudRepository<UsuarioSerieEntity, Integer> {
}
