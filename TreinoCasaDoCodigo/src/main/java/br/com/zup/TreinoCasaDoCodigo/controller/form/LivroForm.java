package br.com.zup.TreinoCasaDoCodigo.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

import br.com.zup.TreinoCasaDoCodigo.model.Autor;
import br.com.zup.TreinoCasaDoCodigo.model.Categoria;
import br.com.zup.TreinoCasaDoCodigo.model.Livro;
import br.com.zup.TreinoCasaDoCodigo.myAnnotacion.ExistsId;
import br.com.zup.TreinoCasaDoCodigo.myAnnotacion.UniqueValue;

public class LivroForm {

	@NotNull
	@NotEmpty
	@NotBlank(message = "titulo é obrigatorio")
	@UniqueValue(domainClass = Livro.class, fielName = "titulo", message = "Esse titulo já existe.")
	private String titulo;
	@NotNull
	@NotEmpty
	@NotBlank(message = "resumo é obrigatorio e no minimo 500 caracteres")
	@Size(min = 10)
	private String resumo;
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco;
	@NotNull
	@Min(100)
	private Long NumeroPaginas;
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate DataDePublicacao;
	@NotNull
	@ExistsId(domainClass = Categoria.class, fielName = "id", message = "O id categoria precisa estar cadastrado no sistema.")
	private Long idCategoria;
	@NotNull
	@ExistsId(domainClass = Autor.class, fielName = "id", message = "O id Autor precisa estar cadastrado no sistema.")
	private Long idAutor;

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

	public LocalDate getDataDePublicacao() {
		return DataDePublicacao;
	}

	public void setDataDePublicacao(LocalDate dataDePublicacao) {
		DataDePublicacao = dataDePublicacao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public LivroForm(@NotEmpty @NotBlank(message = "titulo é obrigatorio") String titulo,
			@NotEmpty @NotBlank(message = "resumo é obrigatorio e no minimo 500 caracteres") @Length(min = 1) String resumo,
			String sumario, @NotNull @Min(20) BigDecimal preco,
			@NotEmpty @NotBlank(message = "O numero de página é obrigatorioe não pode ser menos que 10") @Min(100) Long numeroPaginas,
			@Future LocalDate dataDePublicacao,
			@NotEmpty @NotBlank(message = "categoria é obrigatorio tem de estar cadastrado no sistema") Long idCategoria,
			@NotEmpty @NotBlank(message = "Autor é obrigatorio e tem de estar cadastrado no sistema") Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.NumeroPaginas = numeroPaginas;
		this.DataDePublicacao = dataDePublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public LivroForm() {
	}

	public static Livro converter(@Valid LivroForm livroForm, EntityManager manager) {
		@NotNull
		Categoria categoria = manager.find(Categoria.class, livroForm.getIdCategoria());
		@NotNull
		Autor autor = manager.find(Autor.class, livroForm.getIdAutor());

		Assert.state(autor != null,
				"É impossivel cadastrar um livro para um autor que não está cadastrado" + livroForm.getIdAutor());
		;
		Assert.state(categoria != null,
				"É impossivel cadastrar um livro para um autor que não está cadastrado" + livroForm.getIdCategoria());
		;

		return new Livro(livroForm.getTitulo(), livroForm.getResumo(), livroForm.getSumario(), livroForm.getPreco(),
				livroForm.getNumeroPaginas(), livroForm.getDataDePublicacao(), categoria, autor);
	}
}
