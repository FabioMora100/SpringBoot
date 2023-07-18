package com.trabajoPractico.trabajoPractico.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "estudiante")
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dni")
    private  int dni;
    @Column(name ="email" )
    private  String email;
    @Column(name ="fechaDeNacimiento" )
    private LocalDate fechaDeNacimiento;
    @Column(name ="apellido" )
    private String apellido;
    //@Transient
    private int edad;
    @Column(name = "nombre")
    private String nombre;
    public  boolean esMayorEdad(){
        return edad >=18;
    }

}
