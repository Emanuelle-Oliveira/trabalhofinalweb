package web.trabalhofinal.model.filter;

import web.trabalhofinal.model.Categoria;
import web.trabalhofinal.model.Uf;

public class EjFilter {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cidade;
	private Uf uf;
	private String cnpj;
	private Categoria categoria;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "EjFilter [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cidade="
				+ cidade + ", cnpj=" + cnpj + ", categoria=" + categoria + "]";
	}	
}
