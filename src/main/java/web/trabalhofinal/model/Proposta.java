package web.trabalhofinal.model;

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
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "proposta")
@DynamicUpdate
public class Proposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "data_hora")
	private LocalDateTime dataHora;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_post")
	@JsonIgnore
	private Post post;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ej")
	@JsonIgnore
	private Ej ej;
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
	
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
	
	public Post getPost() {
		return post;
	}
	
	public void setPost(Post post) {
		this.post = post;
	}
	
	public Ej getEj() {
		return ej;
	}
	
	public void setEj(Ej ej) {
		this.ej = ej;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Proposta [id=" + id + ", dataHora=" + dataHora + ", post=" + post + ", ej=" + ej + ", status=" + status
				+ "]";
	}
}
