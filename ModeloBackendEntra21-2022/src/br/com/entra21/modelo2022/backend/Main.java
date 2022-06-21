package br.com.entra21.modelo2022.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	private static Scanner entrada = new Scanner(System.in);
	private static ArrayList<String> opcoes;

	// TODO 01-logica constante
	private static final byte LIMITE_TENTATIVA = 3;

	public static void main(String[] args) {

		// TODO 02-poo acesso estatico
		IRepositorio.gerarMassaTeste();

		// TODO 01-logica variaveis
		byte opcao;
		do {// TODO 01-logica do-while
			System.out.println(montarMenu());
			try {
				opcao = entrada.nextByte();// TODO 01-logica interação com usuário
			} catch (InputMismatchException e) {// TODO 03-avançado Expeptions default
				opcao = -2;// TODO 01-logica atribuição de variavel
				entrada = new Scanner(System.in);
			}

			switch (opcao) {// TODO 01-logica switch
			case 0:
				System.out.println("Até a proxima!");
				break;
			case 1:
				Principal.entrar(LIMITE_TENTATIVA);
				break;
			case 2:
				Principal.cadastrar(LIMITE_TENTATIVA);
				break;
			case 3:
				Principal.recuperarSenha(LIMITE_TENTATIVA);// TODO 01-logica constante
				break;
			case 4:
				Principal.exibirInformacoesSobre();
				break;

			default:
				System.out.println("Escolha uma opção válida");
				break;
			}

		} while (opcao != 0);// TODO 01-logica operador igualdade
		System.out.println("Obrigado, volte sempre que quiser aprender mais");

	}

	private static String montarMenu() {// TODO 01-logica método

		if (opcoes == null) {// TODO 01-logica if

			Tradutor tradutor = IRepositorio.tradutor;
			opcoes = new ArrayList<>(Arrays.asList(tradutor.getEntrar(), tradutor.getCadastrar(),
					tradutor.getRecuperarSenha(), tradutor.getSobre()));
		}

		String menu = "Bem vindo ao sistema Cursos - Entra21:";
		menu += "\n\t0 - "+IRepositorio.tradutor.getEncerrar();// TODO 01-logica incremento
		for (int opcao = 0; opcao < opcoes.size(); opcao++) {// TODO 01-logica for
			menu += "\n\t" + (opcao + 1) + " - " + opcoes.get(opcao);// TODO 01-logica concatenação
		}
		menu += "\n--------------------------------------------------------";
		menu += "\n Escolha uma opção:";
		menu += "\n--------------------------------------------------------";

		return menu;
	}

}
