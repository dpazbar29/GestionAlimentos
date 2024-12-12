package com.practica.gestionalimentos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "seccion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer limite;

    private Integer accesibilidad;

    @ManyToOne
    @JoinColumn(name = "almacen_id")
    private Almacen almacen;

    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL)
    private List<Recipiente> recipientes;
}
