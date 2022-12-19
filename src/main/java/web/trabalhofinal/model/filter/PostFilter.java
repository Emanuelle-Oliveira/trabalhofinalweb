package web.trabalhofinal.model.filter;

import java.time.LocalDateTime;

import javax.persistence.Column;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import web.trabalhofinal.model.Categoria;
import web.trabalhofinal.model.Cliente;
import web.trabalhofinal.model.Proposta;

public class PostFilter {
	private Long id;
	private String descricao;
	private Categoria categoria;
	private LocalDateTime dataHora;
	private Long idCliente;
	private Long idPropostaEscolhida;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getIdPropostaEscolhida() {
		return idPropostaEscolhida;
	}
	public void setIdPropostaEscolhida(Long idPropostaEscolhida) {
		this.idPropostaEscolhida = idPropostaEscolhida;
	}
	@Override
	public String toString() {
		return "PostFilter [id=" + id + ", descricao=" + descricao + ", categoria=" + categoria + ", dataHora="
				+ dataHora + ", idCliente=" + idCliente + ", idPropostaEscolhida=" + idPropostaEscolhida + "]";
	}
}
