package com.practica.gestionalimentos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "alimento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Boolean perecedero;

    private Boolean abierto;

    private Integer tamanyo;

    private LocalDate fechaCaducidad;

    @ManyToOne
    @JoinColumn(name = "seccion_id")
    private Seccion seccion;

    @ManyToOne
    @JoinColumn(name = "recipiente_id")
    private Recipiente recipiente;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private Estado estado;
}
