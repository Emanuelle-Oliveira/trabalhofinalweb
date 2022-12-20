package web.trabalhofinal.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

@Entity 
@DiscriminatorValue ("ej")
@DynamicUpdate
public class Ej extends Usuario{

	@NotBlank(message = "A cidade é obrigatória")
	private String cidade;
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O estado é obrigatório")
	private Uf uf;
	@NotBlank(message = "O CNPJ é obrigatório")
	private String cnpj;
	@Enumerated(EnumType.STRING)
	@NotNull(message = "A categoria é obrigatória")
	private Categoria categoria;
	@Column(name = "url_imagem")
	@NotBlank(message = "A URL da logo é obrigatória")
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
