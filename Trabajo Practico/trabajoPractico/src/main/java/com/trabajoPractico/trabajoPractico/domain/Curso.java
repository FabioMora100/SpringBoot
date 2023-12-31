package com.trabajoPractico.trabajoPractico.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "nombre")
    private  String nombre;
    @Column(name = "descripcion")
    private  String descripcion;
    @Column(name = "fechaDeInicio")
    private LocalDate fechaDeInicio;
    @Column(name = "fechaDeFin")
    private LocalDate fechaDeFin;

}
