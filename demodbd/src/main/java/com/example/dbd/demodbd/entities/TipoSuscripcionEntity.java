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
public class TipoSuscripcionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idTipoSuscripcion;
    private String nombre;
    private String descripcion;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "tipoSuscripcionEntity"
    )
    private List<SuscripcionEntity> suscripcionEntities;

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
    @JsonManagedReference
    public List<SuscripcionEntity> getSuscripcionEntities() {
        return suscripcionEntities;
    }
    public void setSuscripcionEntities(List<SuscripcionEntity> suscripcionEntities) {
        this.suscripcionEntities = suscripcionEntities;
    }

}
