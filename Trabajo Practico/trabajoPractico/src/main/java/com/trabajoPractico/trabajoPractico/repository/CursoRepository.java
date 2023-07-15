package com.trabajoPractico.trabajoPractico.repository;

import com.trabajoPractico.trabajoPractico.domain.Curso;
import com.trabajoPractico.trabajoPractico.domain.Estudiante;
import com.trabajoPractico.trabajoPractico.domain.Inscription;
import com.trabajoPractico.trabajoPractico.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT c FROM Curso c")
    List<Curso> finAllCursos();
   /* @Query("SELECT c FROM Curso c WHERE c.fechaDeInicio > '2020-02-01'")
    List<Curso>finAllPostFecha();*/
    @Query("SELECT c FROM Curso c WHERE c.fechaDeInicio > :estado")
    List<Curso> findAllESTADO(@Param("estado") LocalDate estado);

}
