package web.trabalhofinal.model;

public enum Categoria {
	TECNOLOGIA("Tecnologia"),
	SAUDE("Saúde"),
	GESTAO_PESSOAS("Gestão de Pessoas"),
	CIVIL("Civil"),
	QUIMICA("Química"),
	JURIDICO("Jurídico"),
	AMBIENTAL("Ambiental"),
	MECANICA("Mecânica"),
	ADMINISTRACAO("Administração"),
	MARKETING("Marketing");
	
	private String descricao;
	
	private Categoria(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
