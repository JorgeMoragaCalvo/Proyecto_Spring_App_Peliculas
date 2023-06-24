package com.example.dbd.demodbd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String contrasena;
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoUsuario_id")
    private TipoUsuarioEntity tipoUsuarioEntity;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_suscripcion",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "suscripcion_id")
    )
    private List<SuscripcionEntity> suscripcionEntities;

    public List<SuscripcionEntity> getSuscripcionEntities() {
        return suscripcionEntities;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @JsonBackReference
    public TipoUsuarioEntity getTipoUsuarioEntity() {
        return tipoUsuarioEntity;
    }

    public void setTipoUsuarioEntity(TipoUsuarioEntity tipoUsuarioEntity) {
        this.tipoUsuarioEntity = tipoUsuarioEntity;
    }
}
