package com.example.dbd.demodbd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TemporadaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long idTemporada;

    private String glosa;
    private int anio;

    @ManyToOne()
    @JoinColumn(name = "serie_id")
    private SerieEntity serieEntity;

    @JsonBackReference
    public SerieEntity getSerieEntity() {
        return serieEntity;
    }

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "temporadaEntity"
    )
    private List<CapituloEntity> capituloEntities;

    @JsonManagedReference
    public List<CapituloEntity> getCapituloEntities() {
        return capituloEntities;
    }

    public void setCapituloEntities(List<CapituloEntity> capituloEntities) {
        this.capituloEntities = capituloEntities;
    }

    public void setSerieEntity(SerieEntity serieEntity) {
        this.serieEntity = serieEntity;
    }

    public long getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(long idTemporada) {
        this.idTemporada = idTemporada;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
