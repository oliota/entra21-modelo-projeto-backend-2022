package br.com.entra21.modelo2022.backend.exceptions;

public class FuncionarioExistenteException extends Exception {
	
	public FuncionarioExistenteException() {
		super("\"N�o � possivel utilizar esse CPF, pois j� esta em uso.");
	}

}
