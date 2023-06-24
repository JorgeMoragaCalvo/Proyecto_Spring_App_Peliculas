package com.example.dbd.demodbd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class SuscripcionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idSuscripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private String numeroTarjeta;
    private Short diaFacturacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoSuscripcion_id")
    private TipoSuscripcionEntity tipoSuscripcionEntity;

    public Long getIdSuscripcion() {
        return idSuscripcion;
    }
    public void setIdSuscripcion(Long idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    public Short getDiaFacturacion() {
        return diaFacturacion;
    }
    public void setDiaFacturacion(Short diaFacturacion) {
        this.diaFacturacion = diaFacturacion;
    }

    @JsonBackReference
    public TipoSuscripcionEntity getTipoSuscripcionEntity() {
        return tipoSuscripcionEntity;
    }

    public void setTipoSuscripcionEntity(TipoSuscripcionEntity tipoSuscripcionEntity) {
        this.tipoSuscripcionEntity = tipoSuscripcionEntity;
    }
}
