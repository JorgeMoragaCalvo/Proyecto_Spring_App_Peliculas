package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.PeliculaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends CrudRepository<PeliculaEntity, Long> {
}
