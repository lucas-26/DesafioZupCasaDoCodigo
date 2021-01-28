package br.com.zup.TreinoCasaDoCodigo.controller.form;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import com.sun.istack.NotNull;
import org.springframework.util.*;

import br.com.zup.TreinoCasaDoCodigo.model.ComecoFluxoPagamento;
import br.com.zup.TreinoCasaDoCodigo.model.Estado;
import br.com.zup.TreinoCasaDoCodigo.model.Pais;
import br.com.zup.TreinoCasaDoCodigo.myAnnotacion.ExistsId;

public class ComecoFluxoPagamentoForm {
	
	@NotNull
	@NotEmpty
	@Email
	private String email;
	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private String sobrenome;
	@NotBlank
	private String documentooucpfoucnpj;
	@NotNull
	@NotEmpty
	private String endereco;
	@NotNull
	@NotEmpty
	private String complemento;
	@NotNull
	@NotEmpty
	private String cidade;
	@ExistsId(domainClass = Pais.class, fielName = "id", message = "pais é obrigatorio")
	private long pais;
	@ExistsId(domainClass = Estado.class, fielName = "id")
	private Long estado;
	@NotNull
	@NotEmpty
	private String telefone;
	@NotNull
	@NotEmpty
	private String cep;
	
	public String getEmail() {
		return email;
	}
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public String getDocumentooucpfoucnpj() {
		return this.documentooucpfoucnpj;
	}
	
	public boolean documentoValido() {
		Assert.hasLength(documentooucpfoucnpj, "O documento não foi preenchido ");
		
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);
		
		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);
		
		return cpfValidator.isValid(documentooucpfoucnpj, null) || cnpjValidator.isValid(documentooucpfoucnpj, null); 
	}
	
	public String getEndereco() {
		return endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public Long getPais() {
		return pais;
	}
	public Long getEstado() {
		return estado;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getCep() {
		return cep;
	}
	
	public ComecoFluxoPagamentoForm() {}
	
	public ComecoFluxoPagamentoForm(@Email String email, @NotEmpty String nome, @NotEmpty String sobrenome,
			@CPF @CNPJ String documentooucpfoucnpj, @NotEmpty String endereco, @NotEmpty String complemento,
			@NotEmpty String cidade, @NotEmpty Long pais, Long estado, @NotEmpty String telefone,
			@NotEmpty String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documentooucpfoucnpj = documentooucpfoucnpj;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public static ComecoFluxoPagamento converter(@Valid ComecoFluxoPagamentoForm comecoPagamento) {
		return new ComecoFluxoPagamento(comecoPagamento.getEmail(), comecoPagamento.getNome(), comecoPagamento.getSobrenome(),
				comecoPagamento.getDocumentooucpfoucnpj(), comecoPagamento.getEndereco(), comecoPagamento.getComplemento(),
				comecoPagamento.getCidade(), comecoPagamento.getPais(), comecoPagamento.getEstado(), comecoPagamento.getTelefone(),
				comecoPagamento.getCep());
	}
}
