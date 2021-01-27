package br.com.zup.TreinoCasaDoCodigo.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import br.com.zup.TreinoCasaDoCodigo.model.Autor;
import br.com.zup.TreinoCasaDoCodigo.model.Categoria;
import br.com.zup.TreinoCasaDoCodigo.model.Livro;

public class LivroDto {

	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private long numeroDePaginas;
	private String isbn;
	private LocalDate DataDePublicacao;
	private CategoriaDto categoria;
	private AutorDto autor;

	public Long getId() {
		return id;
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

	public long getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataDePublicacao() {
		return DataDePublicacao;
	}

	public CategoriaDto getCategoria() {
		return categoria;
	}

	public AutorDto getAutor() {
		return autor;
	}

	public LivroDto(Long id, String titulo, String resumo, String sumario, BigDecimal preco, long numeroDePaginas,
			String isbn, LocalDate dataDePublicacao, CategoriaDto categoria, AutorDto autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		DataDePublicacao = dataDePublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public LivroDto() {
	}

	public LivroDto converter(Optional<Livro> livro, EntityManager entityManager) {

		Autor autor = entityManager.find(Autor.class, livro.get().getautor().getId());
		AutorDto autorDto = AutorDto.converter(autor);
		Categoria categoria = entityManager.find(Categoria.class, livro.get().getcategoria().getId());
		CategoriaDto categoriaDto = CategoriaDto.converter(categoria);

		return new LivroDto(livro.get().getId(), livro.get().getTitulo(), livro.get().getResumo(),
				livro.get().getSumario(), livro.get().getPreco(), livro.get().getNumeroPaginas(), livro.get().getIsbn(),
				livro.get().getDataDePublicacao(), categoriaDto, autorDto);
	}

	public static List<LivroDto> converter(List<Livro> livros, EntityManager entityManager) {
		List<LivroDto> livrosDto = new ArrayList<LivroDto>();

		livros.forEach(livro -> {

			Autor autor = entityManager.find(Autor.class, livro.getautor().getId());
			AutorDto autorDto = AutorDto.converter(autor);
			Categoria categoria = entityManager.find(Categoria.class, livro.getcategoria().getId());
			CategoriaDto categoriaDto = CategoriaDto.converter(categoria);

			LivroDto livroDto = new LivroDto(livro.getId(), livro.getTitulo(), livro.getResumo(), livro.getSumario(),
					livro.getPreco(), livro.getNumeroPaginas(), livro.getIsbn(), livro.getDataDePublicacao(),
					categoriaDto, autorDto);

			livrosDto.add(livroDto);
		});
		return livrosDto;
	}

}
