package com.cohorte11.AerolineaAPI.controller;

import com.cohorte11.AerolineaAPI.model.Pasajero;
import com.cohorte11.AerolineaAPI.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        public ResponseEntity<List<Pasajero>> obtenerPasajeros() {
            return ResponseEntity.ok(pasajeroService.findAll());
        }
        //Retorna pasajero con ese ID
        @GetMapping("/{id}")
        public ResponseEntity<Pasajero> obtenerPorId(@PathVariable Long id) {
            Pasajero pasajero = pasajeroService.findById(id);
            if (pasajero == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(pasajero);
        }
        //Crea un pasajero nuevo
        @PostMapping
        public ResponseEntity<Pasajero> crear(@RequestBody Pasajero pasajero) {
            return ResponseEntity.status(HttpStatus.CREATED).body(pasajeroService.save(pasajero));
        }
        //Actualiza un pasajero existente
        @PutMapping("/{id}")
        public ResponseEntity<Pasajero> actualizar(@PathVariable Long id, @RequestBody Pasajero datos) {
            Pasajero actualizado = pasajeroService.update(id, datos);
            if (actualizado == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(actualizado);
        }
        //Elimina un pasajero por ID
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable Long id) {
            pasajeroService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }


