package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.CategoriaEntity;
import com.example.dbd.demodbd.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/categorias")
public class CategoriaController {

    public final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping("/createCategoria/")
    public CategoriaEntity createCategorias(CategoriaEntity categoriaEntity){
        return categoriaService.createCategorias(categoriaEntity);
    }

    @GetMapping("/getAllCategorias/")
    public List<CategoriaEntity> getAllCategorias(){
        return categoriaService.getAllCategorias();
    }

    @GetMapping("/getCategoriaById/{id}")
    public Optional<CategoriaEntity> getCategoriaById(@PathVariable(value = "id") Long id){
        Optional<CategoriaEntity> optionalCategoriaEntity = categoriaService.getCategoriasById(id);
        if(!optionalCategoriaEntity.isPresent()) throw new RuntimeException("La categoria con el id: " + id + " no existe");
        return optionalCategoriaEntity;
    }

    @PutMapping("/updateCategoria/{id}")
    public CategoriaEntity updateCategoria(@PathVariable(value = "id") Long id, @RequestBody CategoriaEntity categoriaEntity){
        return categoriaService.updateCategorias(id, categoriaEntity);
    }

    @DeleteMapping("/deleteCategoria/{id}")
    public void deleteCategoria(@PathVariable(value = "id") Long id){
        categoriaService.deleteCategorias(id);
    }
}