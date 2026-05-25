package com.cohorte11.AerolineaAPI.dto;

import com.cohorte11.AerolineaAPI.model.ClaseAsiento;
import com.cohorte11.AerolineaAPI.model.Reserva;

import java.time.LocalDateTime;

public class ReservaResponseDTO {
    private Long id;
    private LocalDateTime fechaReserva;
    private ClaseAsiento clase;
    private Long pasajeroId;
    private String pasajeroNombre;
    private Long vueloId;
    private String vueloOrigen;
    private String vueloDestino;

    public ReservaResponseDTO() {
    }
    public static ReservaResponseDTO desde(Reserva reserva){
        ReservaResponseDTO reservaDTO = new ReservaResponseDTO();
        reservaDTO.id = reserva.getId();
        reservaDTO.fechaReserva = reserva.getFechaReserva();
        reservaDTO.clase = reserva.getClase();
        reservaDTO.pasajeroId = reserva.getPasajero().getId();
        reservaDTO.pasajeroNombre =reserva.getPasajero().getNombre() + " " + reserva.getPasajero().getApellido();
        reservaDTO.vueloId = reserva.getVuelo().getId();
        reservaDTO.vueloOrigen = reserva.getVuelo().getOrigen();
        reservaDTO.vueloDestino = reserva.getVuelo().getDestino();
        return reservaDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPasajeroNombre() {
        return pasajeroNombre;
    }

    public void setPasajeroNombre(String pasajeroNombre) {
        this.pasajeroNombre = pasajeroNombre;
    }

    public Long getVueloId() {
        return vueloId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }

    public String getVueloOrigen() {
        return vueloOrigen;
    }

    public void setVueloOrigen(String vueloOrigen) {
        this.vueloOrigen = vueloOrigen;
    }

    public String getVueloDestino() {
        return vueloDestino;
    }

    public void setVueloDestino(String vueloDestino) {
        this.vueloDestino = vueloDestino;
    }
}
