package br.com.zup.TreinoCasaDoCodigo.controller.dto;

public class AutorDto {
	
	private String nome;
	private String email;
	private String descricao;
	private String mensagem;
	
	public AutorDto() {}
	
	public AutorDto(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public AutorDto(String nome, String email, String descricao, String mensagem) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.mensagem = mensagem;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMensagem() {
		return mensagem;
	}
}