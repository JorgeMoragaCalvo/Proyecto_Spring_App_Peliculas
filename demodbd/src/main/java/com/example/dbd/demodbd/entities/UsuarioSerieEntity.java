package com.example.dbd.demodbd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UsuarioSerieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idUsuarioSerie;

    private Short valoracion;
    private Boolean favorito;
    private Boolean visualizado;
    private Time tiempoVisualizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuarioEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serie_id")
    private SerieEntity serieEntity;

    public Integer getIdUsuarioSerie() {
        return idUsuarioSerie;
    }
    public void setIdUsuarioSerie(Integer idUsuarioSerie) {
        this.idUsuarioSerie = idUsuarioSerie;
    }
    public Short getValoracion() {
        return valoracion;
    }
    public void setValoracion(Short valoracion) {
        this.valoracion = valoracion;
    }
    public Boolean getFavorito() {
        return favorito;
    }
    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }
    public Boolean getVisualizado() {
        return visualizado;
    }
    public void setVisualizado(Boolean visualizado) {
        this.visualizado = visualizado;
    }
    public Time getTiempoVisualizacion() {
        return tiempoVisualizacion;
    }
    public void setTiempoVisualizacion(Time tiempoVisualizacion) {
        this.tiempoVisualizacion = tiempoVisualizacion;
    }

    public SerieEntity getSerieEntity() {
        return serieEntity;
    }

    public void setSerieEntity(SerieEntity serieEntity) {
        this.serieEntity = serieEntity;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }
}
