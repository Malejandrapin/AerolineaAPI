package com.cohorte11.AerolineaAPI.controller;

import com.cohorte11.AerolineaAPI.model.Vuelo;
import com.cohorte11.AerolineaAPI.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Vuelo> obtenerVuelos() {
        return vueloService.findAll();
    }
    //Retorna vuelo con ese ID
    @GetMapping("/{id}")
    public Vuelo obtenerPorId(@PathVariable Long id) {
        return vueloService.findById(id);
    }
    //Crea un vuelo nuevo
    @PostMapping
    public Vuelo crear(@RequestBody Vuelo vuelo) {
        return vueloService.save(vuelo);
    }
    //Actualiza un vuelo existente
    @PutMapping("/{id}")
    public Vuelo actualizar(@PathVariable Long id, @RequestBody Vuelo datos) {
        return vueloService.update(id, datos);
    }
    //Elimina un vuelo por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        vueloService.delete(id);
    }
}
