package com.example.dbd.demodbd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idCategoria;

    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "pelicula_categoria",
            joinColumns = @JoinColumn(name = "categoria_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id")
    )
    private List<PeliculaEntity> peliculaEntities;

    public List<PeliculaEntity> getPeliculaEntities() {
        return peliculaEntities;
    }


    /*
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "categoriaEntity"
    )
    private List<PeliculaEntity> peliculaEntities;
    */

    /*
    @JsonManagedReference
    public List<PeliculaEntity> getPeliculaEntities() {
        return peliculaEntities;
    }

    public void setPeliculaEntities(List<PeliculaEntity> peliculaEntities) {
        this.peliculaEntities = peliculaEntities;
    }
    */

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
