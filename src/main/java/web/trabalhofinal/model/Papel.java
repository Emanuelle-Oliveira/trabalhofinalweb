package web.trabalhofinal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "papel")
public class Papel implements Serializable {

	private static final long serialVersionUID = 3377158425416402634L; // gere um outro valor

	@Id
	@SequenceGenerator(name="gerador", sequenceName="papel_codigo_seq", allocationSize=1)
	@GeneratedValue(generator="gerador", strategy=GenerationType.SEQUENCE)
	private Long id;
	private String nome;

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

	@Override
	public String toString() {
		return "Papel [id=" + id + ", nome=" + nome + "]";
	}
}