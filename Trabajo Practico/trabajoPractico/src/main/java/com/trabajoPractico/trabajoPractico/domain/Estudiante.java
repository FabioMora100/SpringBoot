package com.trabajoPractico.trabajoPractico.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name ="apellido" )
    private String apellido;
    @Column(name ="email" )
    private  String email;
    @Column(name = "dni")
    private  int dni;
    @Column(name ="fechaDeNacimiento" )
    private LocalDate fechaDeNacimiento;

    //@Transient
    private int edad;

    public  boolean esMayorEdad(){
        return edad >=18;
    }

}
