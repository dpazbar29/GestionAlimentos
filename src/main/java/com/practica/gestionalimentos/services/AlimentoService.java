package com.practica.gestionalimentos.services;

import com.practica.gestionalimentos.entities.Alimento;
import com.practica.gestionalimentos.entities.Categoria;
import com.practica.gestionalimentos.repositories.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentoService {
    @Autowired
    private AlimentoRepository alimentoRepository;

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
}
