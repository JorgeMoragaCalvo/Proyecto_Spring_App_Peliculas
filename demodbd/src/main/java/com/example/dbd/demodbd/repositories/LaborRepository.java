package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.ClasificacionEntity;
import com.example.dbd.demodbd.entities.LaborEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaborRepository extends CrudRepository<LaborEntity, Integer> {
}
