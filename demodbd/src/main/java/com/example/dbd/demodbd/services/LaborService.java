package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.LaborEntity;
import com.example.dbd.demodbd.repositories.LaborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaborService {

    public final LaborRepository laborRepository;

    @Autowired
    public LaborService(LaborRepository laborRepository){
        this.laborRepository = laborRepository;
    }

    public LaborEntity createLabores(LaborEntity laborEntity){
        return laborRepository.save(laborEntity);
    }

    public List<LaborEntity> getAllLabores(){
        return (List<LaborEntity>)laborRepository.findAll();
    }

    public Optional<LaborEntity> getAllLaboresById(Integer id){
        return laborRepository.findById(id);
    }

    public LaborEntity updateLabores(Integer id, LaborEntity laborEntity){
        if(!laborRepository.existsById(id)) throw new RuntimeException("No existe la labor");
        laborEntity.setIdLabor(id);
        return laborRepository.save(laborEntity);
    }

    public void deleteLabores(Integer id) {
        laborRepository.deleteById(id);
    }
}
