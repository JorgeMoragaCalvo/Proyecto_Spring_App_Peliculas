package com.example.dbd.demodbd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "serie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long idSerie;
    private String titulo;
    private String descripcion;
    private int anio;

//    @ManyToMany(mappedBy = "series")
//    private List<UsuarioEntity> usuarios;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TemporadaEntity> temporadas = new ArrayList<>();
}
