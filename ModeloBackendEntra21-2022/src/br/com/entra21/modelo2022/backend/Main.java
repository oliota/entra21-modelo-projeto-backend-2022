package br.com.entra21.modelo2022.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main   {
	
 
	private static Scanner entrada = new Scanner(System.in);
	private static ArrayList<String> opcoes;
	private static final byte LIMITE_TENTATIVA=3;
	
	public static void main(String[] args) {
		
		IRepositorio.gerarMassaTeste(); 

		byte opcao;
		do {
			System.out.println(montarMenu());
			try {
				opcao = entrada.nextByte();
			} catch (InputMismatchException e) {
				opcao=-2;
				entrada=new Scanner(System.in);
			}

			switch (opcao) {
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
				Principal.recuperarSenha(LIMITE_TENTATIVA);
				break;
			case 4: 
				Principal.exibirInformacoesSobre();
				break; 

			default:
				System.out.println("Escolha uma opção válida");
				break;
			}

		} while (opcao != 0);
		System.out.println("Obrigado, volte sempre que quiser aprender mais");

	}

	private static String montarMenu() {
		
		if(opcoes==null) {
			opcoes = new ArrayList<>(Arrays.asList("Entrar","Cadastrar","Esqueci a senha","Sobre"));
		}
		
 
		String menu = "Bem vindo ao sistema Cursos - Entra21:";
		menu += "\n\t0 - Sair";
		for (int opcao = 0; opcao < opcoes.size(); opcao++) {
			menu += "\n\t"+(opcao+1)+" - "+opcoes.get(opcao);
		} 
		menu += "\n--------------------------------------------------------";
		menu += "\n Escolha uma opção:";
		menu += "\n--------------------------------------------------------";

		return menu;
	}

}
