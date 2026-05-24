package com.cohorte11.AerolineaAPI.repository;

import com.cohorte11.AerolineaAPI.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {
}
