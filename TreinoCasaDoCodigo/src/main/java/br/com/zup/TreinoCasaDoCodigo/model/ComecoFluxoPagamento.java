package br.com.zup.TreinoCasaDoCodigo.model;

public class ComecoFluxoPagamento {

	private Long id;
	private String email;
	private String nome;
	private String sobrenome;
	private String documentooucpfoucnpj;
	private String endereco;
	private String complemento;
	private String cidade;
	private Long pais;
	private Long estado;
	private String telefone;
	private String cep;
	
	public Long getId() {
		return id;
	}
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
		return documentooucpfoucnpj;
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
	
	public ComecoFluxoPagamento() { }
	
	public ComecoFluxoPagamento(String email, String nome, String sobrenome, String documentooucpfoucnpj,
			String endereco, String complemento, String cidade, Long pais, Long estado, String telefone,
			String cep) {
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
	
	
}
