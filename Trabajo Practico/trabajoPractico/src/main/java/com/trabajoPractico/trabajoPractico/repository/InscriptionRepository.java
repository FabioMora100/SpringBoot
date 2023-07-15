package com.trabajoPractico.trabajoPractico.repository;

import com.trabajoPractico.trabajoPractico.domain.Inscription;
import com.trabajoPractico.trabajoPractico.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    @Query("SELECT c FROM Inscription c WHERE c.status =Status.RECHAZADO OR c.status=Status.PENDIENTE")
    List<Inscription>findByRECHAZADOorPENDIENTE();
    @Query("SELECT c FROM Inscription c WHERE c.status = :estado")
    List<Inscription> findAllESTADO(@Param("estado") Status estado);
    @Query(value = "SELECT * FROM inscription c WHERE c.status = :estado",nativeQuery = true)
    List<Inscription> findAllEstadoNative(@Param("estado") Status estado);

    List<Inscription>findByOrderByStatusAsc();
}
