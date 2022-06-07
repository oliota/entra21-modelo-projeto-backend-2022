package br.com.entra21.modelo2022.backend.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cliente  extends Pessoa{

	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizacao;
	private ArrayList<String> reclamacoes;
	
	
	public Cliente() {
		super(); 
	}

	public Cliente(String nome) {
		super(nome); 
	}
	public Cliente(String nome, byte idade) {
		super(nome, idade); 
	}
	public Cliente(String nome, byte idade, String cpf) {
		super(nome, idade, cpf); 
	}

	public Cliente(String nome, byte idade, String cpf, ArrayList<String> reclamacoes) {
		super(nome, idade, cpf);
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = this.dataCadastro;
		this.reclamacoes = reclamacoes;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public ArrayList<String> getReclamacoes() {
		return reclamacoes;
	}

	public void setReclamacoes(ArrayList<String> reclamacoes) {
		this.reclamacoes = reclamacoes;
	}

	@Override
	public String toString() {
		return "Cliente [dataCadastro=" + dataCadastro + ", dataAtualizacao=" + dataAtualizacao + ", reclamacoes="
				+ reclamacoes + ", getNome()=" + getNome() + ", getIdade()=" + getIdade() + ", getCpf()=" + getCpf()
				+ "]";
	}

	 
	
	
	
	
	
	

}
