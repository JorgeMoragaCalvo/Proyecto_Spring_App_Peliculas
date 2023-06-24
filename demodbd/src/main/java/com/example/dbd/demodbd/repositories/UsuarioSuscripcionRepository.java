package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.UsuarioSuscripcionEntity;
import com.example.dbd.demodbd.entities.UsuarioSuscripcionId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioSuscripcionRepository extends CrudRepository<UsuarioSuscripcionEntity, UsuarioSuscripcionId> {
}
