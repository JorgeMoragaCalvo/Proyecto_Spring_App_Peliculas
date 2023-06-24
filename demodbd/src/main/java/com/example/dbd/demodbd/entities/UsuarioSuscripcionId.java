package com.example.dbd.demodbd.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSuscripcionId implements Serializable {

    private Long usuarioId;
    private Long suscripcionId;

}