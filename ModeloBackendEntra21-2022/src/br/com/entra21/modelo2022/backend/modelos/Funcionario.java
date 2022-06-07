package br.com.entra21.modelo2022.backend.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Funcionario extends Pessoa {

	private LocalDateTime dataAdmissao;
	private LocalDateTime dataDemissao;
	private ArrayList<String> feedbacks;

	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcionario(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	public Funcionario(String nome, byte idade) {
		super(nome, idade);
		// TODO Auto-generated constructor stub
	}

	public Funcionario(String nome, byte idade, String cpf) {
		super(nome, idade, cpf);
		// TODO Auto-generated constructor stub
	}

	public Funcionario(String nome, byte idade, String cpf,LocalDateTime dataAdmissao, LocalDateTime dataDemissao, ArrayList<String> feedbacks) {
		super(nome, idade, cpf);
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
		this.feedbacks = feedbacks;
	}

	public LocalDateTime getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDateTime dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDateTime getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDateTime dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public ArrayList<String> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(ArrayList<String> feedbacks) {
		this.feedbacks = feedbacks;
	}
	
	

}
