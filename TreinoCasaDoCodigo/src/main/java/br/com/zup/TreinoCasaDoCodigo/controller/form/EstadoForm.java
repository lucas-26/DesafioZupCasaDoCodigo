package br.com.zup.TreinoCasaDoCodigo.controller.form;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.zup.TreinoCasaDoCodigo.model.Estado;
import br.com.zup.TreinoCasaDoCodigo.model.Pais;
import br.com.zup.TreinoCasaDoCodigo.myAnnotacion.ExistsId;
import br.com.zup.TreinoCasaDoCodigo.myAnnotacion.UniqueValue;

public class EstadoForm {

	@NotEmpty
	@NotNull
	@UniqueValue(domainClass = Estado.class, fielName = "nome", message = "Não foi possivel cadastrar esse Estado")
	private String nome;
	@NotNull
	@ExistsId(domainClass = Pais.class, fielName = "id", message = "Não foi possivel cadastrar esse estado com esse pais")
	private Long Idpais;

	public String getNome() {
		return nome;
	}

	public Long getIdpais() {
		return Idpais;
	}

	public EstadoForm(@NotEmpty String nome, Long Idpais) {
		super();
		this.nome = nome;
		this.Idpais = Idpais;
	}

	public static Estado converter(@Valid EstadoForm estadoForm, EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, estadoForm.getIdpais());
		return new Estado(estadoForm.getNome(), pais);
	}
}
