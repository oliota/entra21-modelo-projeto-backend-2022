package br.com.entra21.modelo2022.backend.exceptions;

public class FuncionarioExistenteException extends Exception {
	
	public FuncionarioExistenteException() {
		super("\"Não é possivel utilizar esse CPF, pois já esta em uso.");
	}

}
