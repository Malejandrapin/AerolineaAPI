package com.cohorte11.AerolineaAPI.dto;

import com.cohorte11.AerolineaAPI.model.ClaseAsiento;

import java.time.LocalDateTime;

public class ReservaRequestDTO {
    private LocalDateTime fechaReserva;
    private ClaseAsiento clase;
    private Long pasajeroId;
    private Long vueloId;

    //constructor vacio
    public ReservaRequestDTO() {
    }

}
