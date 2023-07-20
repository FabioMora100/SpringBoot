package com.trabajoPractico.trabajoPractico.Controller;

import com.trabajoPractico.trabajoPractico.Service.InscripcionService;
import com.trabajoPractico.trabajoPractico.dto.InscriptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscription")
public class InscriptionController {
    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping
    public  void save(@RequestBody InscriptionDTO inscriptionDTO){
        inscripcionService.insc(inscriptionDTO.getEstudiante().getId(),inscriptionDTO.getCurso().getId(), inscriptionDTO.getFechaDeInscripcion());
    }
}
