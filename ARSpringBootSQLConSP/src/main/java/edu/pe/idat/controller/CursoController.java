package edu.pe.idat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pe.idat.entity.Curso;
import edu.pe.idat.service.CursoService;

@RestController
@RequestMapping("/Curso")
public class CursoController {
	
    @Autowired
    CursoService cursoService;
    
	@GetMapping("/listar")
	public List<Curso> listarCursos() {
		return cursoService.listarCursos();
	}

	@GetMapping("/obtenerxid/{idcurso}")
	public Curso obtenerCurso(@PathVariable String idcurso) {
		return cursoService.obtenerCursoxId(idcurso);
	}
	
    @PostMapping("/registrar")
    public Map<String, Boolean> save(@RequestBody Curso curso) {
    	cursoService.registrarCurso(curso);
    	Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("respuesta", Boolean.TRUE);
        return response;
    }
    
    @PutMapping("/actualizar")
    public Map<String, Boolean> actualizarCurso(@RequestBody Curso curso) {
    	cursoService.actualizarCurso(curso);
    	Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("respuesta", Boolean.TRUE);
        return response;
    }
	

}
