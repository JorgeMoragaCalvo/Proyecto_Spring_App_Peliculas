package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.TemporadaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporadaRepository extends CrudRepository<TemporadaEntity, Long> {
}
