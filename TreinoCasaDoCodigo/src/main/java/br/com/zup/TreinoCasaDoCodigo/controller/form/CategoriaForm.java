package br.com.zup.TreinoCasaDoCodigo.controller.form;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.zup.TreinoCasaDoCodigo.model.Categoria;

public class CategoriaForm {

	@NotNull @NotEmpty @NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}
	
	public CategoriaForm(@NotEmpty @NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	public Categoria Converter(@Valid CategoriaForm categoriaForm) {
		return new Categoria(categoriaForm.getNome());
	}
}
