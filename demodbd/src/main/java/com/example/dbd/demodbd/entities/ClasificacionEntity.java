package com.example.dbd.demodbd.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ClasificacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idClasificacion;

    private String codigo;
    private String descripcion;


    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "clasificacionEntity"
    )
    private List<PeliculaEntity> peliculaEntities;

    @JsonManagedReference
    public List<PeliculaEntity> getPeliculaEntities() {
        return peliculaEntities;
    }

    public void setPeliculaEntities(List<PeliculaEntity> peliculaEntities) {
        this.peliculaEntities = peliculaEntities;
    }

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "clasificacionEntity"
    )
    private List<SerieEntity> serieEntities;


    @JsonManagedReference
    public List<SerieEntity> getSerieEntities() {
        return serieEntities;
    }

    public void setSerieEntities(List<SerieEntity> serieEntities) {
        this.serieEntities = serieEntities;
    }

    public Long getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Long idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
