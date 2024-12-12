package com.practica.gestionalimentos.services;

import com.practica.gestionalimentos.entities.Almacen;
import com.practica.gestionalimentos.repositories.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmacenService {
    @Autowired
    private AlmacenRepository almacenRepository;

    public List<Almacen> getAllAlmacenes() {
        return almacenRepository.findAll();
    }

    public Almacen saveAlmacen(Almacen almacen) {
        return almacenRepository.save(almacen);
    }

    public void deleteAlmacen(Long id) {
        almacenRepository.deleteById(id);
    }
}
