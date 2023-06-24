package com.example.dbd.demodbd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UsuarioSuscripcionEntity {

    @EmbeddedId
    private UsuarioSuscripcionId  id;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuarioEntity;

    @ManyToOne
    @MapsId("suscripcionId")
    @JoinColumn(name = "suscripcion_id")
    private SuscripcionEntity suscripcionEntity;

    public UsuarioSuscripcionId getId() {
        return id;
    }

    public void setId(UsuarioSuscripcionId id) {
        this.id = id;
    }
    @JsonBackReference
    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }
    @JsonBackReference
    public SuscripcionEntity getSuscripcionEntity() {
        return suscripcionEntity;
    }

    public void setSuscripcionEntity(SuscripcionEntity suscripcionEntity) {
        this.suscripcionEntity = suscripcionEntity;
    }
}
