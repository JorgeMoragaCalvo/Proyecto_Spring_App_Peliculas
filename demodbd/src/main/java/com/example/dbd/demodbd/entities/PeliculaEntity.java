package com.example.dbd.demodbd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_pelicula;

    private String titulo;
    private int anio;
    private String descripcion;
    private String duracion;
    private String nombre_archivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clasificacion")
    private ClasificacionEntity clasificacionEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_productora")
    private ProductoraEntity productoraEntity;

    @JsonIgnore
    @ManyToMany(mappedBy = "peliculaEntities")
    private List<CategoriaEntity> categoriaEntities;

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

    public Long getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(Long id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }
}
