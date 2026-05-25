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

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public ClaseAsiento getClase() {
        return clase;
    }

    public void setClase(ClaseAsiento clase) {
        this.clase = clase;
    }

    public Long getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(Long pasajeroId) {
        this.pasajeroId = pasajeroId;
    }

    public Long getVueloId() {
        return vueloId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }
}
