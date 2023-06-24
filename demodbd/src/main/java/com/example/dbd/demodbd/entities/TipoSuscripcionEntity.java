package com.example.dbd.demodbd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class TipoSuscripcionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idTipoSuscripcion;
    private String nombre;
    private String descripcion;

    public Integer getIdTipoSuscripcion() {
        return idTipoSuscripcion;
    }
    public void setIdTipoSuscripcion(Integer idTipoSuscripcion) {
        this.idTipoSuscripcion = idTipoSuscripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
