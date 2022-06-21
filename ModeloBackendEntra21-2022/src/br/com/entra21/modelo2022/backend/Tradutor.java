	package br.com.entra21.modelo2022.backend;

public enum Tradutor {
	PORTUGUES("Voltar",
			"Encerrar programa",
			"Entrar","Cadastrar",
			"Esqueci a senha",
			"Sobre"), 
	
	INGLES("Back",
			"Close",
			"Login",
			"Register",
			"Forgot Password",
			"About"), 
	
	ALEMAO("Komm zurück",
			"Anwendung schließen",
			"Einloggen",
			"Registrieren",
			"Ich habe das Passwort vergessen",
			"über das System");

	private final String voltar;
	private final String encerrar;
	private final String entrar;
	private final String cadastrar;
	private final String recuperarSenha;
	private final String sobre; 

	private Tradutor(String voltar,String encerrar,String entrar,String cadastrar,String recuperarSenha,String sobre) {
		this.voltar = voltar;
		this.encerrar = encerrar;
		this.entrar = entrar;
		this.cadastrar = cadastrar;
		this.recuperarSenha = recuperarSenha;
		this.sobre = sobre;
	}
	public String getEncerrar() {
		return encerrar;
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
	public String getVoltar() {
		return voltar;
	}

	

	 
}
