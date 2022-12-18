package web.trabalhofinal.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import org.hibernate.annotations.DynamicUpdate;

@Entity 
@DiscriminatorValue ("ej")
@DynamicUpdate
public class Ej extends Usuario{

	private String cidade;
	@Enumerated(EnumType.STRING)
	private Uf uf;
	private String cnpj;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	@Column(name = "url_imagem")
	private String urlImagem;
	
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
	
	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	@Override
	public String toString() {
		return "Ej [cidade=" + cidade + ", uf=" + uf + ", cnpj=" + cnpj + ", categoria=" + categoria + ", urlImagem="
				+ urlImagem + "]";
	}
}
