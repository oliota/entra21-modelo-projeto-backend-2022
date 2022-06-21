package br.com.entra21.modelo2022.backend.exceptions;

public class ClienteNaoLocalizadoException extends Exception {
	
	public ClienteNaoLocalizadoException() {
		super("Não existe um cliente com essa chave.");
	}

}
