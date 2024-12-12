package com.practica.gestionalimentos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "recipiente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tamanyo;

    @ManyToOne
    @JoinColumn(name = "seccion_id")
    private Seccion seccion;

    @OneToMany(mappedBy = "recipiente", cascade = CascadeType.ALL)
    private List<Alimento> alimentos;
}