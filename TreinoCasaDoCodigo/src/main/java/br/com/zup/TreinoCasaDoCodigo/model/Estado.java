package br.com.zup.TreinoCasaDoCodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Deprecated
	public Estado() { }

	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public boolean pertenceAPais(Pais pais2) {
		return this.pais.equals(pais2);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if(nome == null) {
			if(other.getnomePais() != null)
			return false;
		}else if(!nome.equals(other.getnomePais()))
			return false;
		return true;
	}
}
