package com.practica.gestionalimentos.controllers;

import com.practica.gestionalimentos.entities.Seccion;
import com.practica.gestionalimentos.services.SeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/secciones")
public class SeccionController {
    @Autowired
    private SeccionService seccionService;

    @GetMapping
    public List<Seccion> getAllSecciones() {
        return seccionService.getAllSecciones();
    }

    @GetMapping("/{id}")
    public Optional<Seccion> getSeccionById(@PathVariable Long id) {
        return seccionService.getSeccionById(id);
    }

    @PostMapping
    public Seccion createSeccion(@RequestBody Seccion seccion) {
        return seccionService.saveSeccion(seccion);
    }

    @DeleteMapping("/{id}")
    public void deleteSeccion(@PathVariable Long id) {
        seccionService.deleteSeccion(id);
    }
}
