package com.practica.gestionalimentos.repositories;

import com.practica.gestionalimentos.entities.Alimento;
import com.practica.gestionalimentos.entities.Categoria;
import com.practica.gestionalimentos.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    List<Alimento> findByCategoria(Categoria categoria);
    List<Alimento> findByEstado(Estado estado);
    @Query("SELECT a FROM Alimento a WHERE a.fechaCaducidad < CURRENT_DATE")
    List<Alimento> findExpiredFoods();
}
