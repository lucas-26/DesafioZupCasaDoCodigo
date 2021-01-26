package br.com.zup.TreinoCasaDoCodigo.controller.dto;

public class ResponseCategoriaDto {
	
	private CategoriaDto categoria;
	private String menssagem;
	
	public CategoriaDto getCategoria() {
		return categoria;
	}
	public String getMenssagem() {
		return menssagem;
	}
	public ResponseCategoriaDto(CategoriaDto categoria, String menssagem) {
		super();
		this.categoria = categoria;
		this.menssagem = menssagem;
	}
	
	public ResponseCategoriaDto(String menssagem) {
		super();
		this.menssagem = menssagem;
	}
	
	public ResponseCategoriaDto() {}
	
}
