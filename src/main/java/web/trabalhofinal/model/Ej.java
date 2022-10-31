package web.trabalhofinal.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity 
@DiscriminatorValue ("ej")
public class Ej extends Usuario{

	private String cidade;
	private String uf;
	private String cnpj;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Ej [cidade=" + cidade + ", uf=" + uf + ", cnpj=" + cnpj + ", categoria=" + categoria + "]";
	}
}
