package br.com.apisys.instituto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.apisys.instituto.entity.Curso;
import br.com.apisys.instituto.entity.Response;
import br.com.apisys.instituto.repository.CursoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("curso")
public class CursoController {

	private CursoRepository cursoRepository;
	
	@Autowired
	public CursoController(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> listarCurso() {
		return new ResponseEntity<List<Curso>>(this.cursoRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Curso> localizarCurso(@PathVariable("id") Long id) {
		Curso curso = this.cursoRepository.findOne(id);
		
		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> adicionarCurso(@RequestBody Curso curso) {
		this.cursoRepository.save(curso);
		
		return new ResponseEntity<Response>(new Response(1, "Registro Salvo com sucesso!"),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> atualizarCurso(@RequestBody Curso curso) {
		this.cursoRepository.save(curso);
		
		return new ResponseEntity<Response>(new Response(1, "Registro Atualizado com sucesso!"),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> removerCurso(@PathVariable("id") Long id) {
		this.cursoRepository.delete(id);
		
		return new ResponseEntity<Response>(new Response(1, "Registro excluido com sucesso!"), HttpStatus.OK);
	}
	
}