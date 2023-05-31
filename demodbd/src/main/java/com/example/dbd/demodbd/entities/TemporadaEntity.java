package com.example.dbd.demodbd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "temporada")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemporadaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_temporada;
    private String glosa;
    private int anio;

    @ManyToOne
    @JoinColumn(name = "id_serie")
    private SerieEntity serie;

    @OneToMany(mappedBy = "temporada", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CapituloEntity> capitulos = new ArrayList<>();

}
