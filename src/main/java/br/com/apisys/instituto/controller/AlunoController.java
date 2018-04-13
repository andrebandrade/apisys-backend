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

import br.com.apisys.instituto.entity.Aluno;
import br.com.apisys.instituto.entity.Response;
import br.com.apisys.instituto.repository.AlunoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("aluno")
public class AlunoController {

	private AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoController(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Aluno>> listarAluno() {
		return new ResponseEntity<List<Aluno>>(this.alunoRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> localizarAluno(@PathVariable("id") Long id) {
		Aluno aluno = this.alunoRepository.findOne(id);
		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> adicionarAluno(@RequestBody Aluno aluno) {
		this.alunoRepository.save(aluno);
		
		return new ResponseEntity<Response>(new Response(1, "Registro salvo com sucesso!"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> atualizarAluno(@RequestBody Aluno aluno) {
		this.alunoRepository.save(aluno);
		
		return new ResponseEntity<Response>(new Response(1, "Registro Atualizado com sucesso!"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> removerAluno(@PathVariable("id") Long id) {
		this.alunoRepository.delete(id);
		
		return new ResponseEntity<Response>(new Response(1, "Registro excluido com sucesso!"), HttpStatus.OK);
	}
	
}