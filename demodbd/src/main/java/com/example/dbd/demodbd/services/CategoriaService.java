package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.CategoriaEntity;
import com.example.dbd.demodbd.entities.PeliculaEntity;
import com.example.dbd.demodbd.entities.SerieEntity;
import com.example.dbd.demodbd.repositories.CategoriaRepository;
import com.example.dbd.demodbd.repositories.PeliculaRepository;
import com.example.dbd.demodbd.repositories.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private SerieRepository serieRepository;
    public final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaEntity createCategorias(CategoriaEntity categoriaEntity){
        return categoriaRepository.save(categoriaEntity);
    }

    public List<CategoriaEntity> getAllCategorias(){
        return (List<CategoriaEntity>)categoriaRepository.findAll();
    }

    public Optional<CategoriaEntity> getCategoriasById(Long id){
        return categoriaRepository.findById(id);
    }

    public CategoriaEntity updateCategorias(Long id, CategoriaEntity categoriaEntity){
        if(!categoriaRepository.existsById(id)) throw new RuntimeException("No existe la categoria");
        categoriaEntity.setIdCategoria(id);
        return categoriaRepository.save(categoriaEntity);
    }

    public CategoriaEntity assignPeliculaToCategorias(Long id_categoria, Long id_pelicula){
        List<PeliculaEntity> peliculas;
        CategoriaEntity categoriaEntity = categoriaRepository.findById(id_categoria).get();
        PeliculaEntity peliculaEntity = peliculaRepository.findById(id_pelicula).get();
        peliculas = categoriaEntity.getPeliculaEntities();
        peliculas.add(peliculaEntity);
        return categoriaRepository.save(categoriaEntity);
    }

    public CategoriaEntity assignSeriesToCategorias(Long id_categoria, Long id_serie){
        List<SerieEntity> series;
        CategoriaEntity categoriaEntity = categoriaRepository.findById(id_categoria).get();
        SerieEntity serieEntity = serieRepository.findById(id_serie).get();
        series = categoriaEntity.getSerieEntities();
        series.add(serieEntity);
        return categoriaRepository.save(categoriaEntity);
    }

    public void deleteCategorias(Long id) {
        categoriaRepository.deleteById(id);
    }
}
