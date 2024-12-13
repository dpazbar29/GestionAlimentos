package com.practica.gestionalimentos.controllers;

import com.practica.gestionalimentos.entities.Alimento;
import com.practica.gestionalimentos.entities.Categoria;
import com.practica.gestionalimentos.services.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // Endpoint para obtener alimentos próximos a caducar
    @GetMapping("/proximos-a-caducar")
    public ResponseEntity<List<Alimento>> obtenerProximosACaducar(@RequestParam int dias) {
        List<Alimento> proximosACaducar = alimentoService.getAlimentosProximosACaducar(dias);
        return ResponseEntity.ok(proximosACaducar);
    }

    // Endpoint para mover un alimento entre recipientes
    @PostMapping("/{idAlimento}/mover")
    public ResponseEntity<Void> moverAlimento(
            @PathVariable Long idAlimento,
            @RequestParam Long idRecipienteDestino) {
        try {
            alimentoService.moverAlimento(idAlimento, idRecipienteDestino);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Endpoint para obtener alimentos caducados
    @GetMapping("/caducados")
    public ResponseEntity<List<Alimento>> obtenerCaducados() {
        List<Alimento> caducados = alimentoService.getAlimentosCaducados();
        return ResponseEntity.ok(caducados);
    }
}
