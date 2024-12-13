package com.practica.gestionalimentos.services;

import com.practica.gestionalimentos.entities.Seccion;
import com.practica.gestionalimentos.repositories.SeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeccionService {
    @Autowired
    private SeccionRepository seccionRepository;

    public List<Seccion> getAllSecciones() {
        return seccionRepository.findAll();
    }

    public Optional<Seccion> getSeccionById(Long id) {
        return seccionRepository.findById(id);
    }

    public Seccion saveSeccion(Seccion seccion) {
        return seccionRepository.save(seccion);
    }

    public void deleteSeccion(Long id) {
        seccionRepository.deleteById(id);
    }
}

