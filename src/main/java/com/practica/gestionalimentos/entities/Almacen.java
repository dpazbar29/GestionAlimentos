package com.practica.gestionalimentos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "almacen")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String temp;

    @OneToMany(mappedBy = "almacen", cascade = CascadeType.ALL)
    private List<Seccion> secciones;
}
