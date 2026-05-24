package com.cohorte11.AerolineaAPI.controller;

import com.cohorte11.AerolineaAPI.model.Pasajero;
import com.cohorte11.AerolineaAPI.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/pasajeros")
    public class PasajeroController {
        private final PasajeroService pasajeroService;
        //Inyecto PasajeroService por constructor
        @Autowired
        public PasajeroController(PasajeroService pasajeroService) {
            this.pasajeroService = pasajeroService;
        }
        @GetMapping
        public List<Pasajero> obtenerPasajeros() {
            return pasajeroService.findAll();
        }
        //Retorna pasajero con ese ID
        @GetMapping("/{id}")
        public Pasajero obtenerPorId(@PathVariable Long id) {
            return pasajeroService.findById(id);
        }
        //Crea un pasajero nuevo
        @PostMapping
        public Pasajero crear(@RequestBody Pasajero pasajero) {
            return pasajeroService.save(pasajero);
        }
        //Actualiza un pasajero existente
        @PutMapping("/{id}")
        public Pasajero actualizar(@PathVariable Long id, @RequestBody Pasajero datos) {
            return pasajeroService.update(id, datos);
        }
        //Elimina un pasajero por ID
        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Long id) {
            pasajeroService.delete(id);
        }
    }


