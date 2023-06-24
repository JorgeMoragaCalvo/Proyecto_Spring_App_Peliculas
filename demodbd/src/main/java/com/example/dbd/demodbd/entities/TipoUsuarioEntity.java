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
public class TipoUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idTipoUsuario;
    private String nombre;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "tipoUsuarioEntity"
    )
    private List<UsuarioEntity> usuarioEntities;

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }
    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @JsonManagedReference
    public List<UsuarioEntity> getUsuarioEntities() {
        return usuarioEntities;
    }
    public void setUsuarioEntities(List<UsuarioEntity> usuarioEntities) {
        this.usuarioEntities = usuarioEntities;
    }

}
