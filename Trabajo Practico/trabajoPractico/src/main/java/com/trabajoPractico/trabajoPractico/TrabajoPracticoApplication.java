package com.trabajoPractico.trabajoPractico;

import com.trabajoPractico.trabajoPractico.Service.InscripcionService;
import com.trabajoPractico.trabajoPractico.domain.Curso;
import com.trabajoPractico.trabajoPractico.domain.Estudiante;
import com.trabajoPractico.trabajoPractico.domain.Inscription;
import com.trabajoPractico.trabajoPractico.domain.Status;
import com.trabajoPractico.trabajoPractico.repository.CursoRepository;
import com.trabajoPractico.trabajoPractico.repository.EstudianteRepository;
import com.trabajoPractico.trabajoPractico.repository.InscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TrabajoPracticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabajoPracticoApplication.class, args);
	}
	@Autowired
	CursoRepository cursoRepository;

	/*@Autowired
	InscriptionRepository inscriptionRepository;*/

	@Autowired
	EstudianteRepository estudianteRepository;
	@Autowired
	InscripcionService inscripcionService;
	@Autowired
    private  InscriptionRepository inscriptionRepository;

	List<Estudiante>listadoA=new ArrayList<>();
	List<Estudiante>listadoB=new ArrayList<>();
	List<Estudiante>listadoC=new ArrayList<>();
	List<Estudiante>listadoD=new ArrayList<>();



	Curso cursoMatematica = new Curso(null, "Matematicas", "Anual", LocalDate.parse("2000-02-15"), LocalDate.parse("2004-12-10"));
	Curso cursoLengua = new Curso(null, "Lengua", "Semestral", LocalDate.parse("2020-02-15"), LocalDate.parse("2022-06-15"));
	Curso cursoBiologia = new Curso(null, "Biologia", "Semestral", LocalDate.parse("2022-02-01"), LocalDate.parse("2023-06-27"));
	Curso cursoCienciasS = new Curso(null, "Ciencia Sociales", "Anual", LocalDate.parse("2023-03-05"), LocalDate.parse("2025-12-24"));
    private  void saveCursos(){
		cursoRepository.saveAll(Arrays.asList(cursoMatematica, cursoLengua, cursoBiologia, cursoCienciasS));
	}
	private void saveEstudiantes(){
		listadoA.add(new Estudiante(null,20123456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",19,"Fabio"));
		listadoA.add(new Estudiante(null,2723456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio"));
		listadoB.add(new Estudiante(null,76535326,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio"));
		listadoB.add(new Estudiante(null,272456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio"));
		listadoC.add(new Estudiante(null,70123456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio"));
		listadoC.add(new Estudiante(null,80123456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio"));
		listadoD.add(new Estudiante(null,50123456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio"));
		listadoD.add(new Estudiante(null,60123456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio"));
		estudianteRepository.saveAll(Arrays.asList(
				new Estudiante(null,20123456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",19,"Fabio"),
				new Estudiante(null,2723456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio"),
				new Estudiante(null,76535326,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio"),
				new Estudiante(null,272456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio"),
		        new Estudiante(null,70123456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio"),
				new Estudiante(null,80123456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio"),
				new Estudiante(null,50123456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio"),
				new Estudiante(null,60123456,"fabio@gmail.com",LocalDate.parse("2000-02-15"),"Gonzalez",33,"Fabio")
		));

	}
	/*private void saveInscripcion(){
		inscriptionRepository.saveAll(Arrays.asList(
				new Inscription(null,cursoMatematica,LocalDate.parse("2000-02-15"),listadoA, Status.ACEPTADO),
				new Inscription(null,cursoLengua,LocalDate.parse("2000-02-15"),listadoB, Status.RECHAZADO),
				new Inscription(null,cursoCienciasS,LocalDate.parse("2000-02-15"),listadoC, Status.PENDIENTE),
				new Inscription(null,cursoBiologia,LocalDate.parse("2000-02-15"),listadoD, Status.ACEPTADO)

		         ));
	}*/
	private void showCursos(){
		List<Curso> Lalo = cursoRepository.finAllCursos();
		for (Curso c:Lalo) {
			System.out.println(c.getNombre());
		}
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return  args -> {
			saveCursos();
			saveEstudiantes();
			//saveInscripcion();
			showCursos();
            //Listar todos los estudiantes de forma paginada y ordenada ascendente por DNI
			//estudianteRepository.findAll(PageRequest.of(1, 5,Sort.by(Sort.Direction.ASC,"dni")));
			//estudianteRepository.findAll(PageRequest.of(0, 2,Sort.by(Sort.Direction.ASC,"dni")));
			inscripcionService.insc(
					1L,
					2L,
					LocalDate.now(),
					listadoA,
					Status.ACEPTADO

			);



		};
	}

}
