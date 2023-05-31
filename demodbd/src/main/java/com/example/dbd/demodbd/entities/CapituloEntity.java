package com.example.dbd.demodbd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Entity
@Table(name = "capitulo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapituloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_capitulo;
    private String titulo;
    private int numero;
    private String archivo;
    private String nombre_archivo;
    private int duracion;

    @ManyToOne
    @JoinColumn(name = "id_temporada")
    private TemporadaEntity temporada;
}
