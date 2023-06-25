package com.example.dbd.demodbd.repositories;

import com.example.dbd.demodbd.entities.ClasificacionEntity;
import com.example.dbd.demodbd.entities.UsuarioSerieEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioSerieRepository extends CrudRepository<UsuarioSerieEntity, Integer> {
    @Query("SELECT up.serieEntity, AVG(up.valoracion)" +
            "FROM UsuarioSerieEntity up " +
            "GROUP BY up.serieEntity " +
            "ORDER BY AVG(up.valoracion) DESC")
    List<Object[]> getValoracionPromedioPorSerie();
}
