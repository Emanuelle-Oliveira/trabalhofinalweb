package web.trabalhofinal.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

@Entity 
@DiscriminatorValue ("cliente")
@DynamicUpdate
public class Cliente extends Usuario{

	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + "]";
	}
}
