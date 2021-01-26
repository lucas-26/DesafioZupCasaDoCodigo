package br.com.zup.TreinoCasaDoCodigo.controller.form;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.zup.TreinoCasaDoCodigo.model.Categoria;
import br.com.zup.TreinoCasaDoCodigo.myAnnotacion.UniqueValue;

public class CategoriaForm {

	@NotNull @NotEmpty @NotBlank
	@UniqueValue(domainClass = Categoria.class, fielName = "nome", message = "Não foi possivel cadastrar a categoria")
	private String nome;

	public String getNome() {
		return nome;
	}
	
	public CategoriaForm(@NotEmpty @NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	public CategoriaForm() {
	}
	
	public Categoria Converter(@Valid CategoriaForm categoriaForm) {
		return new Categoria(categoriaForm.getNome());
	}
}
