package com.trabajoPractico.trabajoPractico.Controller;

import com.trabajoPractico.trabajoPractico.Service.EstudianteService;
import com.trabajoPractico.trabajoPractico.dto.EstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public EstudianteDTO save(@RequestBody EstudianteDTO estudianteDTO){
        return estudianteService.saveEstudiante(estudianteDTO);
    }
    @GetMapping
    public List<EstudianteDTO>all(){
        return estudianteService.findAll();
    }
    @GetMapping("/{id}")
    public EstudianteDTO find(@PathVariable Long id){return  estudianteService.find(id);}

    @PutMapping("/{id}")
    public EstudianteDTO update(@PathVariable Long id,@RequestBody EstudianteDTO estudianteDTO) {
        return estudianteService.update(id,estudianteDTO);}

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){estudianteService.delete(id);
    }

    }
