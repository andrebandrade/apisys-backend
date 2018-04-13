package br.com.apisys.instituto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apisys.instituto.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
