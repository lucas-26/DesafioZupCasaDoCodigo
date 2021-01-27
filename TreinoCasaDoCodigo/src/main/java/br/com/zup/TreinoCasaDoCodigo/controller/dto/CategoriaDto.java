package br.com.zup.TreinoCasaDoCodigo.controller.dto;

import java.util.Optional;

import br.com.zup.TreinoCasaDoCodigo.model.Categoria;

public class CategoriaDto {

	private String nome;

	public String getNome() {
		return nome;
	}

	public CategoriaDto(String nome) {
		super();
		this.nome = nome;
	}
	
	public CategoriaDto() {}

	public CategoriaDto converter(Optional<Categoria> categoriaEncontrada) {
		return new CategoriaDto(categoriaEncontrada.get().getNome());
	}
	
	public static CategoriaDto converter(Categoria categoriaEncontrada) {
		return new CategoriaDto(categoriaEncontrada.getNome());
		
	}
	
}
