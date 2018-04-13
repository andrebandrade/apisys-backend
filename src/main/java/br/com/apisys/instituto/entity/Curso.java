package br.com.apisys.instituto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "codigo", nullable = false)
	private String codigo;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "instituicao", nullable = false)
	private String instituicao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	
	@Override
	public String toString() {
		return "Curso [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", instituicao=" + instituicao + "]";
	}
	
}