package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.CategoriaEntity;
import com.example.dbd.demodbd.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

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

    public void deleteCategorias(Long id) {
        categoriaRepository.deleteById(id);
    }
}
