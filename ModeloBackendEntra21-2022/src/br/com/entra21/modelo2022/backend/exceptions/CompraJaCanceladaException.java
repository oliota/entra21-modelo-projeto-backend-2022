package br.com.entra21.modelo2022.backend.exceptions;

public class CompraJaCanceladaException extends Exception {
	
	public CompraJaCanceladaException() {
		super("Essa compra já estava cancelada.");
	}

}
