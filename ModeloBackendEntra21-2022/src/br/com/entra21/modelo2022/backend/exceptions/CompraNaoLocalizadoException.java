package br.com.entra21.modelo2022.backend.exceptions;

public class CompraNaoLocalizadoException extends Exception {
	
	public CompraNaoLocalizadoException() {
		super("N�o existe uma compra com essa chave.");
	}

}
