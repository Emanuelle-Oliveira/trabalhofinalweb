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

public class PropostaFilter {
	private Long id;
	private LocalDateTime dataHora;
	private Long idEj;
	private Long idPost;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public Long getIdEj() {
		return idEj;
	}
	public void setIdEj(Long idEj) {
		this.idEj = idEj;
	}
	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}
	@Override
	public String toString() {
		return "PropostaFilter [id=" + id + ", dataHora=" + dataHora + ", idEj=" + idEj + ", idPost=" + idPost + "]";
	}
}
