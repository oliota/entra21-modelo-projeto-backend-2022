package br.com.entra21.modelo2022.backend;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.entra21.modelo2022.backend.modelos.Funcionario;

public class Menu {

	private Scanner entrada;
	private String titulo;
	private ArrayList<String> opcoes;

	public Menu(String titulo, ArrayList<String> opcoes) {
		super();
		this.entrada = new Scanner(System.in);
		this.titulo = titulo;
		this.opcoes = opcoes;
	}

	public void executarMenu() {
		do {
			System.out.println("=========>   MENU " + this.titulo + "   <====  "+exibirDetalhesFuncionarioLogado()+" ==============");
			System.out.println("-1 = "+IRepositorio.tradutor.getEncerrar());
			System.out.println(" 0 = "+IRepositorio.tradutor.getVoltar());
			
			if (opcoes != null && !opcoes.isEmpty()) {
				for (int contador = 0; contador < opcoes.size(); contador++) {
					System.out.println(" " + (contador + 1) + " = " + opcoes.get(contador));
				}
			} else {
				System.out.println("Não há itens especificos para esse menu???");
			}

		} while (capturarOpcao() != 0);
	}

	public byte capturarOpcao() {
		try {
			byte opcao;
			opcao = entrada.nextByte();

			switch (opcao) {

			case -1:
				System.exit(-1);
				break;
			case 0:
				System.out.println("Menu " + this.titulo + " finalizado");
				break;
			}
			return opcao;
		} catch (InputMismatchException e) {
			System.out.println("Valor informado não corresponde ao esperado, tente novamente:");
			entrada=new Scanner(System.in);
			return capturarOpcao();
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public Scanner getEntrada() {
		return entrada;
	}

	private String exibirDetalhesFuncionarioLogado() {

		Funcionario funcionario = Principal.funcionarioLogado;
		return "Funcionário logado:" + funcionario.getNome() + " - CPF - " + funcionario.getCpf()
				+ " - ADMITIDO EM:"
				+ funcionario.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
	}

}
