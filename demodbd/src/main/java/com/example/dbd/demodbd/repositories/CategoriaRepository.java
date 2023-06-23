package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.CategoriaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaEntity, Long> {

}
