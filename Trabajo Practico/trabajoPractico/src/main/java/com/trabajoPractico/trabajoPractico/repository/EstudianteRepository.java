package com.trabajoPractico.trabajoPractico.repository;

import com.trabajoPractico.trabajoPractico.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {

    @Query("SELECT c FROM Estudiante c")
    List<Estudiante> findAllEstudiantes();
    @Query("SELECT c FROM Estudiante c WHERE c.dni > 20000000 AND c.apellido='Romero'")
    List<Estudiante> findByDniAndApellido();
    List<Estudiante>findByOrderByNombreAsc();

    //boolean existsByFirstName(String nombre);

   // long countByFirstName(String nombre);


}
