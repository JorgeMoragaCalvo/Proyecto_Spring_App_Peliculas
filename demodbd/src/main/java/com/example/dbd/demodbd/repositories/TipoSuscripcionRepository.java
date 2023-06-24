package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.TipoSuscripcionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSuscripcionRepository extends CrudRepository<TipoSuscripcionEntity, Integer> {
}
