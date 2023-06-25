package com.example.dbd.demodbd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class TrabajadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idTrabajador;
    private String nombre;
    private String apellidoPrimario;
    private String apellidoSecundario;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "trabajador_pelicula",
            joinColumns = @JoinColumn(name = "trabajador_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id")
    )
    private List<PeliculaEntity> peliculaEntities;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "trabajador_serie",
            joinColumns = @JoinColumn(name = "trabajador_id"),
            inverseJoinColumns = @JoinColumn(name = "serie_id")
    )
    private List<SerieEntity> serieEntities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "labor_id")
    private LaborEntity laborEntity;

    public List<PeliculaEntity> getPeliculaEntities() {
        return peliculaEntities;
    }

    public List<SerieEntity> getSerieEntities() {
        return serieEntities;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPrimario(String apellidoPrimario) {
        this.apellidoPrimario = apellidoPrimario;
    }

    public String getApellidoPrimario() {
        return apellidoPrimario;
    }

    public void setApellidoSecundario(String apellidoSecundario) {
        this.apellidoSecundario = apellidoSecundario;
    }

    public String getApellidoSecundario() {
        return apellidoSecundario;
    }

    @JsonBackReference
    public LaborEntity getLaborEntity() {
        return laborEntity;
    }

    public void setLaborEntity(LaborEntity laborEntity) {
        this.laborEntity = laborEntity;
    }

}
