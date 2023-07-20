package com.trabajoPractico.trabajoPractico.dto;

import com.trabajoPractico.trabajoPractico.domain.Curso;
import com.trabajoPractico.trabajoPractico.domain.Estudiante;
import com.trabajoPractico.trabajoPractico.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class InscriptionDTO {
    private Estudiante estudiante;
    private Curso curso;
    private LocalDate fechaDeInscripcion;
    //private Status status;

}
