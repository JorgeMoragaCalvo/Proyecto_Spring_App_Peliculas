package com.example.dbd.demodbd.controllers;

import com.example.dbd.demodbd.entities.ProductoraEntity;
import com.example.dbd.demodbd.services.ProductoraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demodbd/productoras")
public class ProductoraController {

    public final ProductoraService productoraService;
    public ProductoraController(ProductoraService productoraService){
        this.productoraService = productoraService;
    }

    @PostMapping("/createProductora/")
    public ProductoraEntity createProductora(@RequestBody ProductoraEntity productoraEntity){
        return productoraService.createProductoras(productoraEntity);
    }

    @GetMapping("/getProductoras/")
    public List<ProductoraEntity> getProductoras(){
        return productoraService.getAllProductoras();
    }

    @GetMapping("/getProductoraById/{id}")
    public Optional<ProductoraEntity> getProductoraById(@PathVariable(value = "id") Integer id){
        Optional<ProductoraEntity> optionalProductoraEntity = productoraService.getAllProductorasById(id);
        if(!optionalProductoraEntity.isPresent()) throw new RuntimeException("La Productora con el id: " + id + " no existe");
        return optionalProductoraEntity;
    }

    @PutMapping("/updateProductora/{id}")
    public ProductoraEntity updateProductora(@PathVariable(value = "id") Integer id, @RequestBody ProductoraEntity productoraEntity){
        return productoraService.updateProductoras(id, productoraEntity);
    }

    @DeleteMapping("/deleteProductora/{id}")
    public void deleteProductora(@PathVariable(value = "id") Integer id){
        productoraService.deleteProductoras(id);
    }

}
