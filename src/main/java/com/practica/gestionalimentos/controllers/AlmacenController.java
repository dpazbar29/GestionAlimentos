package com.practica.gestionalimentos.controllers;

import com.practica.gestionalimentos.entities.Almacen;
import com.practica.gestionalimentos.services.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/almacenes")
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;

    @GetMapping
    public List<Almacen> getAllAlmacenes() {
        return almacenService.getAllAlmacenes();
    }

    @PostMapping
    public Almacen saveAlmacen(@RequestBody Almacen almacen) {
        return almacenService.saveAlmacen(almacen);
    }

    @DeleteMapping("/{id}")
    public void deleteAlmacen(@PathVariable Long id) {
        almacenService.deleteAlmacen(id);
    }
}
