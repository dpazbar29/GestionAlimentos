package com.practica.gestionalimentos.controllers;

import com.practica.gestionalimentos.entities.Recipiente;
import com.practica.gestionalimentos.services.RecipienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipientes")
public class RecipienteController {
    @Autowired
    private RecipienteService recipienteService;

    @GetMapping
    public List<Recipiente> getAllRecipientes() {
        return recipienteService.getAllRecipientes();
    }

    @GetMapping("/{id}")
    public Optional<Recipiente> getRecipienteById(@PathVariable Long id) {
        return recipienteService.getRecipienteById(id);
    }

    @PostMapping
    public Recipiente createRecipiente(@RequestBody Recipiente recipiente) {
        return recipienteService.saveRecipiente(recipiente);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipiente(@PathVariable Long id) {
        recipienteService.deleteRecipiente(id);
    }
}
