package br.com.entra21.modelo2022.backend.modelos;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Compra {

	private String clienteChave;
	private String funcionarioChave;
	private LocalDateTime dataCompra;
	private LocalDateTime dataCancelado;
	private HashMap<String,Curso> cursos;
	
	
	public Compra() {
		super();
	}


	public Compra(String clienteChave, String funcionarioChave,
			HashMap<String, Curso> cursos) {
		super();
		this.clienteChave = clienteChave;
		this.funcionarioChave = funcionarioChave;
		this.dataCompra = LocalDateTime.now();
		this.cursos = cursos;
	}


	public String getClienteChave() {
		return clienteChave;
	}


	public void setClienteChave(String clienteChave) {
		this.clienteChave = clienteChave;
	}


	public String getFuncionarioChave() {
		return funcionarioChave;
	}


	public void setFuncionarioChave(String funcionarioChave) {
		this.funcionarioChave = funcionarioChave;
	}


	public LocalDateTime getDataCompra() {
		return dataCompra;
	}


	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}


	public LocalDateTime getDataCancelado() {
		return dataCancelado;
	}


	public void setDataCancelado(LocalDateTime dataCancelado) {
		this.dataCancelado = dataCancelado;
	}


	public HashMap<String, Curso> getCursos() {
		return cursos;
	}


	public void setCursos(HashMap<String, Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
	

}
