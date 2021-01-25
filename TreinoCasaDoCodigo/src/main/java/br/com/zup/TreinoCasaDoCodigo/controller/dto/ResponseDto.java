package br.com.zup.TreinoCasaDoCodigo.controller.dto;

public class ResponseDto {

	private AutorDto autor;
	private String message;
	
	
	public AutorDto getAutor() {
		return autor;
	}
	
	public String getMessage() {
		return message;
	}
	
	public ResponseDto(AutorDto autor, String message) {
		super();
		this.autor = autor;
		this.message = message;
	}
	
	public ResponseDto(String message) {
		super();
		this.message = message;
	}
	
}
