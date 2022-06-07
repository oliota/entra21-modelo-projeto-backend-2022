package br.com.entra21.modelo2022.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main   {
	
 
	private static Scanner entrada = new Scanner(System.in);
	private static ArrayList<String> opcoes;
	public static void main(String[] args) {
		
		Repositorio.gerarMassaTeste();
		System.out.println("\030[3mHello World!\030[0m");

		byte opcao;
		do {
			System.out.println(montarMenu());
			opcao = entrada.nextByte();

			switch (opcao) {
			case 0:
				System.out.println("At� a proxima!");
				break;
			case 1: 
				Principal.entrar();
				break;
			case 2: 
				Principal.cadastrar();
				break;
			case 3: 
				Principal.recuperarSenha();
				break;
			case 4: 
				Principal.exibirInformacoesSobre();
				break; 

			default:
				System.out.println("Escolha uma op��o v�lida para aprender um assunto avan�ado sobre JAVA");
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
		menu += "\n Escolha uma op��o:";
		menu += "\n--------------------------------------------------------";

		return menu;
	}

}
