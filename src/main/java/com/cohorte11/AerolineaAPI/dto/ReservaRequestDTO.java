package com.cohorte11.AerolineaAPI.dto;

import com.cohorte11.AerolineaAPI.model.ClaseAsiento;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ReservaRequestDTO {
    @NotNull(message = "La fecha de reserva es obligatoria")
    private LocalDateTime fechaReserva;

    @NotNull(message = "La clase del asiento es obligatoria")
    private ClaseAsiento clase;

    @NotNull(message = "El id del pasajero es obligatorio")
    private Long pasajeroId;

    @NotNull(message = "El id del vuelo es obligatorio")
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
