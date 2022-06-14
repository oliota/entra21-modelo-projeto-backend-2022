package br.com.entra21.modelo2022.backend.exceptions;

public class SenhaIncorretaException extends Exception {
	
	public SenhaIncorretaException() {
		super("A senha informada está incorreta, tente novamente.");
	}

}
