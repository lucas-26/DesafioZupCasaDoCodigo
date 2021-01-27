package br.com.zup.TreinoCasaDoCodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomePais;
	
	
	public long getId() {
		return id;
	}
	public String getnomePais() {
		return nomePais;
	}
	public Pais() { }
	
	public Pais(String nomePais) {
		this.nomePais = nomePais;
	}
}
