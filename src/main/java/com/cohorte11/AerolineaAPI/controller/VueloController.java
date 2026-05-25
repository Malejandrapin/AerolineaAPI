package com.cohorte11.AerolineaAPI.controller;

import com.cohorte11.AerolineaAPI.model.Vuelo;
import com.cohorte11.AerolineaAPI.service.VueloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Vuelos", description = "Gestión de vuelos de la aerolínea")
@RestController
@RequestMapping("/vuelos")
public class VueloController {
    private final VueloService vueloService;

    //Inyecto VueloService por constructor
    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @Operation(summary = "Listar todos los vuelos")
    @GetMapping
    public ResponseEntity<List<Vuelo>> obtenerTodos() {
        return ResponseEntity.ok(vueloService.findAll());
    }

    @Operation(summary = "Buscar vuelo por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerPorId(@PathVariable Long id) {
        Vuelo vuelo = vueloService.findById(id);
        if (vuelo == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(vuelo);
    }

    @PostMapping
    public ResponseEntity<Vuelo> crear(@Valid @RequestBody Vuelo vuelo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vueloService.save(vuelo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizar(@PathVariable Long id,@Valid @RequestBody Vuelo datos) {
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