package com.practica.gestionalimentos.controllers;

import com.practica.gestionalimentos.entities.Alimento;
import com.practica.gestionalimentos.entities.Categoria;
import com.practica.gestionalimentos.services.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alimentos")
public class AlimentoController {
    @Autowired
    private AlimentoService alimentoService;

    @GetMapping
    public List<Alimento> getAllAlimentos() {
        return alimentoService.getAllAlimentos();
    }

    @GetMapping("/categoria/{categoria}")
    public List<Alimento> getAlimentosByCategoria(@PathVariable Categoria categoria) {
        return alimentoService.getAlimentosByCategoria(categoria);
    }

    @GetMapping("/expirados")
    public List<Alimento> getExpiredFoods() {
        return alimentoService.getExpiredFoods();
    }

    @PostMapping
    public Alimento saveAlimento(@RequestBody Alimento alimento) {
        return alimentoService.saveAlimento(alimento);
    }

    @DeleteMapping("/{id}")
    public void deleteAlimento(@PathVariable Long id) {
        alimentoService.deleteAlimento(id);
    }
}
