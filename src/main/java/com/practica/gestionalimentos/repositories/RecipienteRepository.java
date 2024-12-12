package com.practica.gestionalimentos.repositories;

import com.practica.gestionalimentos.entities.Recipiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipienteRepository extends JpaRepository<Recipiente, Long> {
}
