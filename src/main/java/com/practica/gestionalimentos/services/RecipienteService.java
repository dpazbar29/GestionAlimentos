package com.practica.gestionalimentos.services;

import com.practica.gestionalimentos.entities.Recipiente;
import com.practica.gestionalimentos.repositories.RecipienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipienteService {
    @Autowired
    private RecipienteRepository recipienteRepository;

    public List<Recipiente> getAllRecipientes() {
        return recipienteRepository.findAll();
    }

    public Optional<Recipiente> getRecipienteById(Long id) {
        return recipienteRepository.findById(id);
    }

    public Recipiente saveRecipiente(Recipiente recipiente) {
        return recipienteRepository.save(recipiente);
    }

    public void deleteRecipiente(Long id) {
        recipienteRepository.deleteById(id);
    }
}

