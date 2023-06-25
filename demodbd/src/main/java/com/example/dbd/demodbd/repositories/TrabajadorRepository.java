package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.CategoriaEntity;
import com.example.dbd.demodbd.entities.TrabajadorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepository extends CrudRepository<TrabajadorEntity, Integer> {

}
