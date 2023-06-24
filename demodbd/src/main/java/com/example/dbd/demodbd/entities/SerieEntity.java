package com.example.dbd.demodbd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
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

    @ManyToOne()
    @JoinColumn(name = "clasificacion_id")
    private ClasificacionEntity clasificacionEntity;

    @JsonBackReference
    public ClasificacionEntity getClasificacionEntity() {
        return clasificacionEntity;
    }

    public void setClasificacionEntity(ClasificacionEntity clasificacionEntity) {
        this.clasificacionEntity = clasificacionEntity;
    }

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "serieEntity"
    )
    private List<TemporadaEntity> temporadaEntities;

    @JsonManagedReference
    public List<TemporadaEntity> getTemporadaEntities() {
        return temporadaEntities;
    }

    public void setTemporadaEntities(List<TemporadaEntity> temporadaEntities) {
        this.temporadaEntities = temporadaEntities;
    }

    @ManyToOne()
    @JoinColumn(name = "productora_id")
    private ProductoraEntity productoraEntity;

    @JsonBackReference
    public ProductoraEntity getProductoraEntity() {
        return productoraEntity;
    }

    public void setProductoraEntity(ProductoraEntity productoraEntity) {
        this.productoraEntity = productoraEntity;
    }

    public long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(long idSerie) {
        this.idSerie = idSerie;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
