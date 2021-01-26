package br.com.zup.TreinoCasaDoCodigo.controller.form;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.zup.TreinoCasaDoCodigo.model.Autor;
import br.com.zup.TreinoCasaDoCodigo.myAnnotacion.UniqueValue;

public class AutorForm {
	
	@NotNull @NotEmpty
	private String nome;
	@UniqueValue(domainClass = Autor.class, fielName = "email", message = "Não foi possivel cadastrar um autor")
	@NotNull @NotEmpty @Email
	private String email;
	@NotNull @NotEmpty @Length(max = 400)
	private String descricao;
	
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
	
	public Autor converter(@Valid AutorForm autorForm) {
		return new Autor(autorForm.getNome(), autorForm.getEmail(), autorForm.getDescricao());
	}
	
}
