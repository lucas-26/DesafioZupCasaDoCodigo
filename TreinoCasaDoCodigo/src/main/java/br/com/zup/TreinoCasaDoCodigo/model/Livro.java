package br.com.zup.TreinoCasaDoCodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.zup.TreinoCasaDoCodigo.myAnnotacion.UniqueValue;

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
	private Long NumeroPaginas;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long isbn;
	private LocalDate DataDePublicacao;
	@OneToOne
	private Categoria categoria;
	@OneToOne
	private Autor autor;

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

	public Long getNumeroPaginas() {
		return NumeroPaginas;
	}

	public Long getIsbn() {
		return isbn;
	}

	public LocalDate getDataDePublicacao() {
		return DataDePublicacao;
	}

	public Categoria gedcategoria() {
		return categoria;
	}

	public Autor getautor() {
		return autor;
	}

	public Livro() {
	}

	public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Long numeroPaginas,
			LocalDate dataDePublicacao, Categoria categoria, Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.NumeroPaginas = numeroPaginas;
		this.DataDePublicacao = dataDePublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

}
