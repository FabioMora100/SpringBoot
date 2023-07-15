package com.trabajoPractico.trabajoPractico.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "inscripcion")
@NoArgsConstructor
@AllArgsConstructor
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private  Curso curso;


    private LocalDate fechaDeInscripcion;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Estudiante> estudiantes;
    @Enumerated(EnumType.STRING)
    private Status status;



}
