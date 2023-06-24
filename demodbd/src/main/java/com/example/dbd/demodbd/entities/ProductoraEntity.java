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
public class ProductoraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idProductora;
    private String nombre;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "productoraEntity"
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
            mappedBy = "productoraEntity"
    )
    private List<SerieEntity> serieEntities;
    @JsonManagedReference
    public List<SerieEntity> getSerieEntities() {
        return serieEntities;
    }
    public void setSerieEntities(List<SerieEntity> serieEntities) {
        this.serieEntities = serieEntities;
    }
    public Integer getIdProductora() {
        return idProductora;
    }
    public void setIdProductora(Integer idProductora) {
        this.idProductora = idProductora;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
