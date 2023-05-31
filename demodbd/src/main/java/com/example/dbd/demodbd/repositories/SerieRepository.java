package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.SerieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends CrudRepository<SerieEntity, Long> {
}
