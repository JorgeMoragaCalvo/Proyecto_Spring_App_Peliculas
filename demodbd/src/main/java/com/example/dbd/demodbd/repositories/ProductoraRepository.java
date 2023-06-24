package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.ProductoraEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoraRepository extends CrudRepository<ProductoraEntity, Integer> {
}
