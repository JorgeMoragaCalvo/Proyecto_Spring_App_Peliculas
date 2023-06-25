package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.CategoriaEntity;
import com.example.dbd.demodbd.entities.PeliculaEntity;
import com.example.dbd.demodbd.entities.TrabajadorEntity;
import com.example.dbd.demodbd.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {
    private PeliculaRepository peliculaRepository;
    private static final String LABOR_DIRECTOR = "Director";
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    private UsuarioPeliculaRepository usuarioPeliculaRepository;

    public PeliculaService(UsuarioPeliculaRepository usuarioPeliculaRepository) {
        this.usuarioPeliculaRepository = usuarioPeliculaRepository;
    }




    public List<PeliculaEntity> getRankingPeliculasMasValoradas(){
        List<Object[]> peliculasValoracionPromedio = usuarioPeliculaRepository.getValoracionPromedioPorPelicula();

        peliculasValoracionPromedio.sort((o1, o2) -> {
            Double valoracion1 = (Double) o1[1];
            Double valoracion2 = (Double) o2[1];
            return valoracion2.compareTo(valoracion1);
        });

        List<PeliculaEntity> rankingPeliculas = new ArrayList<>();
        for(Object[] peliculaValoracionPromedio : peliculasValoracionPromedio){
            PeliculaEntity peliculaEntity = (PeliculaEntity) peliculaValoracionPromedio[0];
            rankingPeliculas.add(peliculaEntity);
        }
        return rankingPeliculas;
    }



    public PeliculaEntity createPeliculas(PeliculaEntity peliculaEntity){
        return peliculaRepository.save(peliculaEntity);
    }

    public List<PeliculaEntity> getAllPeliculas(){
        return (List<PeliculaEntity>)peliculaRepository.findAll();
    }

    public Optional<PeliculaEntity> getAllPeliculasById(Long id){
        return peliculaRepository.findById(id);
    }

    public PeliculaEntity findPeliculaByName(String name) {
        List<PeliculaEntity> Allpeliculas = (List<PeliculaEntity>) peliculaRepository.findAll();
        PeliculaEntity peliculaEntity = null;
        for (PeliculaEntity pelicula : Allpeliculas) {
            if (pelicula.getTitulo().equals(name)) {
                peliculaEntity = pelicula;
            }
        }
        return peliculaEntity;
    }

    public List<PeliculaEntity> findPeliculaByCategory(String nombreCategoria) {
        List<CategoriaEntity> allCategorias = (List<CategoriaEntity>) categoriaRepository.findAll();
        List<PeliculaEntity> filteredPeliculas = new ArrayList<>();
        for (CategoriaEntity categoria : allCategorias) {
            if (categoria.getNombre().equals(nombreCategoria)) {
                filteredPeliculas = categoria.getPeliculaEntities();
                return filteredPeliculas;
            }
        }
        return filteredPeliculas;
    }

    public List<PeliculaEntity> findPeliculaByProducer(String nombreProductora) {
        List<PeliculaEntity> allPeliculas = (List<PeliculaEntity>) peliculaRepository.findAll();
        List<PeliculaEntity> filteredPeliculas = new ArrayList<>();
        for (PeliculaEntity pelicula : allPeliculas) {
            if (pelicula.getProductoraEntity().getNombre().equals(nombreProductora)) {
                filteredPeliculas.add(pelicula);
            }
        }
        return filteredPeliculas;
    }

    public List<PeliculaEntity> findPeliculaByDirectorName(String nombreDirector) {
        List<TrabajadorEntity> allTrabajadores = (List<TrabajadorEntity>) trabajadorRepository.findAll();
        List<PeliculaEntity> filteredPeliculas = new ArrayList<>();
        for (TrabajadorEntity trabajador : allTrabajadores) {
            if (trabajador.getNombre().equals(nombreDirector) && trabajador.getLaborEntity().getNombre().equals(LABOR_DIRECTOR)) {
                filteredPeliculas = trabajador.getPeliculaEntities();
                return filteredPeliculas;
            }
        }
        return filteredPeliculas;
    }

    public PeliculaEntity updatePeliculas(Long id, PeliculaEntity peliculaEntity){
        if(!peliculaRepository.existsById(id)) throw new RuntimeException("No existe la pelicula");
        peliculaEntity.setId_pelicula(id);
        return peliculaRepository.save(peliculaEntity);
    }

    public void deletePeliculas(Long id){
        peliculaRepository.deleteById(id);
    }
}
