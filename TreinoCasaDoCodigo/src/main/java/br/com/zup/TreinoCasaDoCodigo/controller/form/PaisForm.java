package br.com.zup.TreinoCasaDoCodigo.controller.form;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.zup.TreinoCasaDoCodigo.model.Pais;
import br.com.zup.TreinoCasaDoCodigo.myAnnotacion.UniqueValue;

public class PaisForm {

	@NotEmpty
	@NotNull
	@UniqueValue(domainClass = Pais.class, fielName = "nomePais", message = "Não foi possivel cadastrar esse pais")
	private String nomePais;

	public String getnomePais() {
		return nomePais;
	}

	public PaisForm(@NotEmpty String nomePais) {
		super();
		this.nomePais = nomePais;
	}

	public PaisForm() {}
	
	public Pais converter(@Valid PaisForm paisForm) {
		return new Pais(paisForm.getnomePais());
	}
}
