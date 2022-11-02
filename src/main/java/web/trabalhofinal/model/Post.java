package web.trabalhofinal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "post")
@DynamicUpdate
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	private LocalDateTime dataHora;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proposta_escolhida")
	private Proposta propostaEscolhida;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", descricao=" + descricao + ", categoria=" + categoria + ", dataHora=" + dataHora
				+ ", cliente=" + cliente + "]";
	}
}
