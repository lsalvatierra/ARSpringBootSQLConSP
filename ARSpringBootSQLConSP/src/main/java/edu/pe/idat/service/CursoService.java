package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.entity.Curso;
import edu.pe.idat.repository.CursoRepository;
/*
 * @Service para indicar que tiene la lógica de negocio. 
 * Entonces no hay ninguna otra especialidad excepto usarlo en la 
 * capa de servicio.
 * */
@Service
public class CursoService {
	
	/*
	 * @Autowired= Permite resolver o inyectar objetos colaborativos a una clase.
	 * Ejemplo: Inyecta la interfaz CursoRepository a la clase 
	 * CursoService una vez que se crea.
	 * */	
	 	@Autowired
	    CursoRepository cursoRepository;
	    
	    public List<Curso> listarCursos(){
	    	return cursoRepository.listarCursos();
	    }
	    
	    public Curso obtenerCursoxId(String idCurso){
	    	return cursoRepository.obtenerCursoxId(idCurso);
	    }

	    public void registrarCurso(Curso curso){
	    	 cursoRepository.registrarCurso(curso.getNomcurso(), curso.getCredito());
	    }
	    
	    public void actualizarCurso(Curso curso){
	   	 cursoRepository.actualizarCurso(curso.getIdcurso(), curso.getNomcurso(), curso.getCredito());
	   }

}
