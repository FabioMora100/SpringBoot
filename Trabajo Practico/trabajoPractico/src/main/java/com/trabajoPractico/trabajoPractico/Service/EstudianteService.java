package com.trabajoPractico.trabajoPractico.Service;

import com.trabajoPractico.trabajoPractico.domain.Estudiante;
import com.trabajoPractico.trabajoPractico.dto.EstudianteDTO;
import com.trabajoPractico.trabajoPractico.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {
    @Autowired
   private EstudianteRepository estudianteRepository;

    public EstudianteDTO saveEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = new Estudiante(
                null,
                estudianteDTO.getNombre(),
                estudianteDTO.getApellido(),
                estudianteDTO.getEmail(),
                estudianteDTO.getDni(),
                estudianteDTO.getFechaDeNacimiento(),
                estudianteDTO.getEdad()
        );
        estudianteRepository.save(estudiante);
        return estudianteDTO;

    }

    public List<EstudianteDTO> findAll() {
        return estudianteRepository.findAll()
                .stream().map(c -> new EstudianteDTO(c.getNombre(), c.getApellido(), c.getEmail(), c.getDni(), c.getFechaDeNacimiento(), c.getEdad()))
                .collect(Collectors.toList());
    }

    public EstudianteDTO update(Long id, EstudianteDTO estudianteDTO){
        Estudiante estudiante= new Estudiante(id,estudianteDTO.getNombre(),estudianteDTO.getApellido(),estudianteDTO.getEmail(),estudianteDTO.getDni(),estudianteDTO.getFechaDeNacimiento(),estudianteDTO.getEdad());
        estudianteRepository.save(estudiante);
        return estudianteDTO;
    }
    public  EstudianteDTO find(Long id){
        Optional<Estudiante> estudianteOptional=estudianteRepository.findById(id);

        if(estudianteOptional.isEmpty()){
            throw new RuntimeException("Id invalido");
        }
        Estudiante estudiante=estudianteOptional.get();
        return new EstudianteDTO(estudiante.getNombre(), estudiante.getApellido(), estudiante.getEmail(), estudiante.getDni(), estudiante.getFechaDeNacimiento(), estudiante.getEdad());
    }
    public void  delete(Long id){estudianteRepository.deleteById(id);}
}
