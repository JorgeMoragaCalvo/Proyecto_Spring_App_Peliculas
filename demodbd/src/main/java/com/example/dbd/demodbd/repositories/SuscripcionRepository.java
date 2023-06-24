package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.SuscripcionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscripcionRepository extends CrudRepository<SuscripcionEntity, Long> {

}
