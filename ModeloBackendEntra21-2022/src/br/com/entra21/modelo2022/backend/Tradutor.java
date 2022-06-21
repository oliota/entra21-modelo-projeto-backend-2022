	package br.com.entra21.modelo2022.backend;

public enum Tradutor {
	PORTUGUES("Entrar","Cadastrar","Esqueci a senha","Sobre"), 
	INGLES("Login","Register","Forgot Password","About"),  
	ALEMAO("Einloggen","Registrieren","Ich habe das Passwort vergessen","über das System");

	private final String entrar;
	private final String cadastrar;
	private final String recuperarSenha;
	private final String sobre; 

	private Tradutor(String entrar,String cadastrar,String recuperarSenha,String sobre) {
		this.entrar = entrar;
		this.cadastrar = cadastrar;
		this.recuperarSenha = recuperarSenha;
		this.sobre = sobre;
	}

	public String getEntrar() {
		return entrar;
	}

	public String getCadastrar() {
		return cadastrar;
	}

	public String getRecuperarSenha() {
		return recuperarSenha;
	}

	public String getSobre() {
		return sobre;
	}

	 
}
