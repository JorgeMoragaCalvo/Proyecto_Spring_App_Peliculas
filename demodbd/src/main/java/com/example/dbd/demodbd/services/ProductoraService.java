package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.ProductoraEntity;
import com.example.dbd.demodbd.repositories.ProductoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoraService {

    public final ProductoraRepository productoraRepository;

    @Autowired
    public ProductoraService(ProductoraRepository productoraRepository){
        this.productoraRepository = productoraRepository;
    }

    public ProductoraEntity createProductoras(ProductoraEntity productoraEntity){
        return productoraRepository.save(productoraEntity);
    }

    public List<ProductoraEntity> getAllProductoras(){
        return (List<ProductoraEntity>)productoraRepository.findAll();
    }

    public Optional<ProductoraEntity> getAllProductorasById(Integer id){
        return productoraRepository.findById(id);
    }

    public ProductoraEntity updateProductoras(Integer id, ProductoraEntity productoraEntity){
        if(!productoraRepository.existsById(id)) throw new RuntimeException("No existe la productora");
        productoraEntity.setIdProductora(id);
        return productoraRepository.save(productoraEntity);
    }

    public void deleteProductoras(Integer id) {
        productoraRepository.deleteById(id);
    }
}
