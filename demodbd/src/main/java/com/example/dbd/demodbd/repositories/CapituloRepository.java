package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.CapituloEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapituloRepository extends CrudRepository<CapituloEntity, Long> {
}
