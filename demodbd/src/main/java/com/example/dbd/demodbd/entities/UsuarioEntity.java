package com.example.dbd.demodbd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "telefono")
    private String telefono;

//    @ManyToMany
//    @JoinTable(name = "usuario_serie",
//        joinColumns = @JoinColumn(name = "idUsuario"),
//        inverseJoinColumns = @JoinColumn(name = "idSerie"))
//    private List<SerieEntity> series;

//    @ManyToOne
//    @JoinColumn(name = "idTipoUsuario")
//    private TipoUsuarioEntity tipoUsuario;

}
