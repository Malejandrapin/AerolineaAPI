package com.cohorte11.AerolineaAPI.controller;

import com.cohorte11.AerolineaAPI.model.Vuelo;
import com.cohorte11.AerolineaAPI.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {
    private final VueloService vueloService;

    //Inyecto VueloService por constructor
    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping
    public ResponseEntity<List<Vuelo>> obtenerTodos() {
        return ResponseEntity.ok(vueloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerPorId(@PathVariable Long id) {
        Vuelo vuelo = vueloService.findById(id);
        if (vuelo == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(vuelo);
    }

    @PostMapping
    public ResponseEntity<Vuelo> crear( @RequestBody Vuelo vuelo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vueloService.save(vuelo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizar(@PathVariable Long id, @RequestBody Vuelo datos) {
        Vuelo resultado = vueloService.update(id, datos);
        if (resultado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        vueloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}