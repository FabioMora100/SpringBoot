package com.trabajoPractico.trabajoPractico.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "inscripcion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @OneToMany
    @JoinColumn(name = "estudiante_id")
    private  Estudiante estudiante;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private  Curso curso;


    private LocalDate fechaDeInscripcion;

    //@OneToMany(cascade = CascadeType.PERSIST)
   // private List<Estudiante> estudiantes;

   // @Enumerated(EnumType.STRING)
   // private Status status;

}
