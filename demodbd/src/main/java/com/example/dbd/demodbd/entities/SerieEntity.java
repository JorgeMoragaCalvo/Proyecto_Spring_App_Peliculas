package com.example.dbd.demodbd.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SerieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long idSerie;

    private String titulo;
    private String descripcion;
    private int anio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clasificacion")
    private ClasificacionEntity clasificacionEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_productora")
    private ProductoraEntity productoraEntity;

    public ClasificacionEntity getClasificacionEntity() {
        return clasificacionEntity;
    }

    public void setClasificacionEntity(ClasificacionEntity clasificacionEntity) {
        this.clasificacionEntity = clasificacionEntity;
    }

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
