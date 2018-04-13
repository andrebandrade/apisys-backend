package br.com.apisys.instituto.entity;

public class Response {

	private Integer codigo;
	private String mensagem;
	
	public Response() {}
	
	public Response(Integer codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "Response [codigo=" + codigo + ", mensagem=" + mensagem + "]";
	}
	
}
