package com.cohorte11.AerolineaAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "vuelos") //Defino el nombre de la tabla
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El origen no puede estar vacío")
    @Column(nullable = false)
    private String origen;

    @NotBlank(message = "El destino no puede estar vacío")
    @Column(nullable = false)
    private String destino;

    @NotNull(message = "La fecha y hora del vuelo son obligatorias")
    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @NotNull(message = "El estado del vuelo es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoVuelo estado;

    //Constructor vacio para JPA
    public Vuelo() {
    }

    //Constructor con todos los campos
    public Vuelo(Long id, String origen, String destino, LocalDateTime fechaHora, EstadoVuelo estado) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EstadoVuelo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVuelo estado) {
        this.estado = estado;
    }
}
