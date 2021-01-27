package br.com.zup.TreinoCasaDoCodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	@OneToOne
	private Pais pais;
	
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Pais getPais() {
		return pais;
	}
	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}
}
