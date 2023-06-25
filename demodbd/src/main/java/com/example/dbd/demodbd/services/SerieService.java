package com.example.dbd.demodbd.services;

import com.example.dbd.demodbd.entities.PeliculaEntity;
import com.example.dbd.demodbd.entities.SerieEntity;
import com.example.dbd.demodbd.repositories.SerieRepository;
import com.example.dbd.demodbd.repositories.UsuarioPeliculaRepository;
import com.example.dbd.demodbd.repositories.UsuarioSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SerieService{
    private final SerieRepository serieRepository;
    @Autowired
    private UsuarioSerieRepository usuarioSerieRepository;
    @Autowired
    public SerieService(SerieRepository serieRepository){
        this.serieRepository = serieRepository;
    }

    public SerieEntity createSeries(SerieEntity serieEntity){
        return serieRepository.save(serieEntity);
    }

    public Optional<SerieEntity> getAllSeriesById(Long id){
        return serieRepository.findById(id);
    }

    public List<SerieEntity> getAllSeries(){
        return (List<SerieEntity>) serieRepository.findAll();
    }

    public SerieEntity updateSeries(long id, SerieEntity serieEntity){
        if(!serieRepository.existsById(id)) throw new RuntimeException("No existe la serie");
        serieEntity.setIdSerie(id);
        return serieRepository.save(serieEntity);
    }

    public void deleteSeries(long id){
        serieRepository.deleteById(id);
    }

    public List<SerieEntity> getRankingSeriesMasValoradas(){
        List<Object[]> seriesValoracionPromedio = usuarioSerieRepository.getValoracionPromedioPorSerie();

        seriesValoracionPromedio.sort((o1, o2) -> {
            Double valoracion1 = (Double) o1[1];
            Double valoracion2 = (Double) o2[1];
            return valoracion2.compareTo(valoracion1);
        });

        List<SerieEntity> rankingSeries = new ArrayList<>();
        for(Object[] serieValoracionPromedio : seriesValoracionPromedio){
            SerieEntity serieEntity = (SerieEntity) serieValoracionPromedio[0];
            rankingSeries.add(serieEntity);
        }
        return rankingSeries;
    }
}
