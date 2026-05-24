package com.cohorte11.AerolineaAPI.repository;

import com.cohorte11.AerolineaAPI.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {
}
