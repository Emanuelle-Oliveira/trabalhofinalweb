package web.trabalhofinal.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "proposta")
@DynamicUpdate
public class Proposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dataHora;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_post")
	private Post post;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ej")
	private Ej ej;
	
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

	@Override
	public String toString() {
		return "Proposta [id=" + id + ", dataHora=" + dataHora + ", post=" + post + ", ej=" + ej + "]";
	}
}
