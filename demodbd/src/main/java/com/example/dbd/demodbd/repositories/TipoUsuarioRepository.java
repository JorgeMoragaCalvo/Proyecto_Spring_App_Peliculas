package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.TipoUsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends CrudRepository<TipoUsuarioEntity, Integer> {
}
