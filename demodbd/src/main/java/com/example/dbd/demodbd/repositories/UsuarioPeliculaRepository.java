package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.UsuarioPeliculaEntity;
import com.example.dbd.demodbd.entities.UsuarioSerieEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioPeliculaRepository extends CrudRepository<UsuarioPeliculaEntity, Integer> {

    @Query("SELECT up.peliculaEntity, AVG(up.valoracion)" +
            "FROM UsuarioPeliculaEntity up " +
            "GROUP BY up.peliculaEntity" +
            " ORDER BY AVG(up.valoracion) DESC")
    List<Object[]> getValoracionPromedioPorPelicula();
}
