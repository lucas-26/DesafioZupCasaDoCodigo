package br.com.zup.TreinoCasaDoCodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(unique = true)
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private long numeroDePaginas;
	@Column(unique = true)
	private String isbn;
	private LocalDate DataDePublicacao;
	@OneToOne
	private Categoria categoria;
	@OneToOne
	private Autor autor;
	
	public Long getId() {
		return Id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public long getNumeroPaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataDePublicacao() {
		return DataDePublicacao;
	}

	public Categoria getcategoria() {
		return categoria;
	}

	public Autor getautor() {
		return autor;
	}

	public Livro() {
	}

	public Livro(String titulo, String resumo, String sumario, BigDecimal preco, long numeroDePaginas, 
			String isbn ,LocalDate dataDePublicacao, Categoria categoria, Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.DataDePublicacao = dataDePublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

}
