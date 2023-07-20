package com.trabajoPractico.trabajoPractico.Service;

import com.trabajoPractico.trabajoPractico.domain.Curso;
import com.trabajoPractico.trabajoPractico.domain.Estudiante;
import com.trabajoPractico.trabajoPractico.domain.Inscription;
import com.trabajoPractico.trabajoPractico.domain.Status;
import com.trabajoPractico.trabajoPractico.repository.CursoRepository;
import com.trabajoPractico.trabajoPractico.repository.EstudianteRepository;
import com.trabajoPractico.trabajoPractico.repository.InscriptionRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Validated
public class InscripcionService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Transactional
    public  void insc(@NotNull @Positive Long estudianteId,@NotNull @Positive(message ="El id no puede ser negativo") Long cursoId,  LocalDate inscStartDate){
       // Objects.requireNonNull(cursoId, "El id no es valido");

        Estudiante estudiante= estudianteRepository
                .findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("El id del estudiante no es valido"));

        if (!estudiante.esMayorEdad()){
            throw new RuntimeException("El estudiante es menor de edad");
        }

        Curso curso=cursoRepository
                .findById(cursoId)
                .orElseThrow(()-> new RuntimeException("El id del Curso no es valido"));


        Inscription inscription=new Inscription(
                null,
                estudiante,
                curso,
                inscStartDate

        );
        inscriptionRepository.save(inscription);

    }
}
