package br.com.apisys.instituto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apisys.instituto.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
