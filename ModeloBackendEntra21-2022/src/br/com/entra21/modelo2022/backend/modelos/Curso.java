package br.com.entra21.modelo2022.backend.modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;

public class Curso {

	private String nome;
	private String preRequisitos[];
	private double valor;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	private HashSet<String> ementa;
	private String planoAulas[][];

	public Curso() {

	}

	public Curso(String nome) {
		super();
		this.nome = nome;
	}

	public Curso(String nome, double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public Curso(String nome, String[] preRequisitos, double valor, LocalDate dataInicio, LocalDate dataFim,
			LocalTime horaInicio, LocalTime horaFim, HashSet<String> ementa) {
		super();
		this.nome = nome;
		this.preRequisitos = preRequisitos;
		this.valor = valor;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.ementa = ementa;
	}

	public Curso(String nome, String[] preRequisitos, double valor, LocalDate dataInicio, LocalDate dataFim,
			LocalTime horaInicio, LocalTime horaFim, HashSet<String> ementa, String[][] planoAulas) {
		super();
		this.nome = nome;
		this.preRequisitos = preRequisitos;
		this.valor = valor;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.ementa = ementa;
		this.planoAulas = planoAulas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String[] getPreRequisitos() {
		return preRequisitos;
	}

	public void setPreRequisitos(String[] preRequisitos) {
		this.preRequisitos = preRequisitos;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}

	public HashSet<String> getEmenta() {
		return ementa;
	}

	public void setEmenta(HashSet<String> ementa) {
		this.ementa = ementa;
	}

	@Override
	public String toString() {
		String detalhe = "Curso:" + nome;
		detalhe += "\n\t- Valor:R$ " + valor;

		detalhe += "\n\t- Datas:";
		detalhe += "\n\t\t- Inicio:" + dataInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		detalhe += "\n\t\t- Fim:" + dataFim.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		detalhe += "\n\t- Horarios:";
		detalhe += "\n\t\t- Inicio:" + horaInicio;
		detalhe += "\n\t\t- Fim:" + horaFim;

		if (preRequisitos != null) {
			detalhe += "\n\t- Pre-requisitos:"+(preRequisitos.length==0?"Nenhum":"");
			for (String preRequisito : preRequisitos) {
				detalhe += "\n\t\t- " + preRequisito;
			}
		}

		detalhe += "\n\t- Ementa";
		for (String itemEmenta : ementa) {
			detalhe += "\n\t\t- " + itemEmenta;
		}

		detalhe += "\n\tPlano de aula";
		if (planoAulas != null) {
			for (int aula = 0; aula < planoAulas.length; aula++) {
				detalhe += "\n\t\t- Aula " + (aula + 1);
				for (String topico : planoAulas[aula]) {
					detalhe += "\n\t\t\t- " + topico;
				}
			}
		}

		return detalhe;
	}

	public String[][] getPlanoAulas() {
		return planoAulas;
	}

	public void setPlanoAulas(String planoAulas[][]) {
		this.planoAulas = planoAulas;
	}

}
