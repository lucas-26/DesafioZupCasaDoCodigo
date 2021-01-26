package br.com.zup.TreinoCasaDoCodigo.controller.dto;

public class ResponseAutorDto {

	private AutorDto autor;
	private String message;
	
	
	public AutorDto getAutor() {
		return autor;
	}
	
	public String getMessage() {
		return message;
	}
	
	public ResponseAutorDto(AutorDto autor, String message) {
		super();
		this.autor = autor;
		this.message = message;
	}
	
	public ResponseAutorDto(String message) {
		super();
		this.message = message;
	}
	
}
