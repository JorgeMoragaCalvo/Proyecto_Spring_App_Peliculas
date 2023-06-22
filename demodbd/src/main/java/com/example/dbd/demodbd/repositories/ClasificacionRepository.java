package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.ClasificacionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasificacionRepository extends CrudRepository<ClasificacionEntity, Long> {
}
