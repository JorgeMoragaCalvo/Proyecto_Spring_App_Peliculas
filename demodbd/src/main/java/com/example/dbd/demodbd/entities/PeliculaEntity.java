package com.example.dbd.demodbd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_pelicula;
    
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "anio")
    private int anio;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "duracion")
    private String duracion;
    @Column(name = "nombre_archivo")
    private String nombre_archivo;

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
