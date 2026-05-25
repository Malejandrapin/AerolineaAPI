package com.cohorte11.AerolineaAPI.service;

import com.cohorte11.AerolineaAPI.dto.ReservaRequestDTO;
import com.cohorte11.AerolineaAPI.dto.ReservaResponseDTO;
import com.cohorte11.AerolineaAPI.model.Pasajero;
import com.cohorte11.AerolineaAPI.model.Reserva;
import com.cohorte11.AerolineaAPI.model.Vuelo;
import com.cohorte11.AerolineaAPI.repository.PasajeroRepository;
import com.cohorte11.AerolineaAPI.repository.ReservaRepository;
import com.cohorte11.AerolineaAPI.repository.VueloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final PasajeroRepository pasajeroRepository;
    private final VueloRepository vueloRepository;

    public ReservaService(ReservaRepository reservaRepository,
                          PasajeroRepository pasajeroRepository,
                          VueloRepository vueloRepository) {
        this.reservaRepository = reservaRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.vueloRepository = vueloRepository;
    }
    public List<ReservaResponseDTO> findAll(){
        return reservaRepository.findAll()
                .stream()
                .map(ReservaResponseDTO::desde)
                .collect(Collectors.toList());
    }

    public ReservaResponseDTO findById(Long id){
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if(reserva == null) return null;
        return ReservaResponseDTO.desde(reserva);
    }

    public ReservaResponseDTO save(ReservaRequestDTO dto) {
        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId()).orElse(null);
        Vuelo vuelo = vueloRepository.findById(dto.getVueloId()).orElse(null);
        Reserva reserva = new Reserva(dto.getFechaReserva(),dto.getClase(),pasajero,vuelo);
        return ReservaResponseDTO.desde(reservaRepository.save(reserva));
    }

    public ReservaResponseDTO update(Long id, ReservaRequestDTO dto) {
        Reserva existente = reservaRepository.findById(id).orElse(null);
        if(existente == null) return null;
        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId()).orElse(null);
        Vuelo vuelo = vueloRepository.findById(dto.getVueloId()).orElse(null);
        existente.setFechaReserva(dto.getFechaReserva());
        existente.setClase(dto.getClase());
        existente.setPasajero(pasajero);
        existente.setVuelo(vuelo);
        return ReservaResponseDTO.desde(reservaRepository.save(existente));
    }

    public void delete(Long id) {reservaRepository.deleteById(id);}

}
