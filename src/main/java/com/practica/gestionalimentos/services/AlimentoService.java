package com.practica.gestionalimentos.services;

import com.practica.gestionalimentos.entities.Alimento;
import com.practica.gestionalimentos.entities.Categoria;
import com.practica.gestionalimentos.entities.Estado;
import com.practica.gestionalimentos.entities.Recipiente;
import com.practica.gestionalimentos.repositories.AlimentoRepository;
import com.practica.gestionalimentos.repositories.RecipienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlimentoService {
    @Autowired
    private AlimentoRepository alimentoRepository;
    private RecipienteRepository recipienteRepository;

    public List<Alimento> getAllAlimentos() {
        return alimentoRepository.findAll();
    }

    public List<Alimento> getAlimentosByCategoria(Categoria categoria) {
        return alimentoRepository.findByCategoria(categoria);
    }

    public List<Alimento> getExpiredFoods() {
        return alimentoRepository.findExpiredFoods();
    }

    public Alimento saveAlimento(Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    public void deleteAlimento(Long id) {
        alimentoRepository.deleteById(id);
    }

    // Rotación de alimentos: Priorizar alimentos próximos a caducar
    public List<Alimento> getAlimentosProximosACaducar(int dias) {
        LocalDate fechaLimite = LocalDate.now().plusDays(dias);
        return alimentoRepository.findAll().stream()
                .filter(alimento -> alimento.getFechaCaducidad() != null &&
                        alimento.getFechaCaducidad().isBefore(fechaLimite) &&
                        alimento.getEstado() != Estado.CADUCADO)
                .toList();
    }

    // Mover alimentos entre recipientes
    @Transactional
    public void moverAlimento(Long idAlimento, Long idRecipienteDestino) {
        Alimento alimento = alimentoRepository.findById(idAlimento)
                .orElseThrow(() -> new RuntimeException("Alimento no encontrado"));

        Recipiente recipienteDestino = recipienteRepository.findById(idRecipienteDestino)
                .orElseThrow(() -> new RuntimeException("Recipiente no encontrado"));

        // Validar espacio en el recipiente destino
        Long espacioOcupado = recipienteDestino.getAlimentos().stream()
                .mapToLong(Alimento::getTamanyo)
                .sum();
        if (espacioOcupado + alimento.getTamanyo() > recipienteDestino.getTamanyo()) {
            throw new RuntimeException("No hay suficiente espacio en el recipiente destino");
        }

        // Actualizar el recipiente del alimento
        alimento.setRecipiente(recipienteDestino);
        alimentoRepository.save(alimento);
    }

    // Alertas de alimentos caducados
    public List<Alimento> getAlimentosCaducados() {
        return alimentoRepository.findExpiredFoods();
    }
}
