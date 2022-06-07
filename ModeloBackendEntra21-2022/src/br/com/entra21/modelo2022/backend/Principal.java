package br.com.entra21.modelo2022.backend;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.entra21.modelo2022.backend.anottations.FaltaImplementar;
import br.com.entra21.modelo2022.backend.area.logada.MenuPrincipal;

public class Principal {

	@FaltaImplementar
	public static void entrar() {

		new MenuPrincipal("PRINCIPAL", new ArrayList<String>(Arrays.asList("Cadastros", "Relat�rios"))).executarMenu(); 
	}

	@FaltaImplementar
	public static void cadastrar() {

	}

	@FaltaImplementar
	public static void recuperarSenha() {

	}

	public static void exibirInformacoesSobre() {
		System.out.println("============================== SOBRE ==================================");
		System.out.println("Projeto desenvolvido pela EU-quipe Oliota");
		System.out.println("Objetivo");
		System.out.println(
				"\tServir de modelo para constru��o dos projetos em grupo para os alunos do entra21-2022 (Melhor turma de java)");
		System.out.println(
				"\tEm cada etapa o projeto ser� atualizado e salvo em branches diferentes para manter o historico de evolu��o");
		System.out.println("");
		System.out.println("Escopo");
		System.out.println(
				"\tProjeto para cadastro, relat�rios e regras de negocios envolvendo o assunto GESTOR DE CURSOS");
		System.out.println(
				"\tO catalogo de cursos � oferecido pela institui��o e os clientes optam por adquirir os cursos");
		System.out.println("\tCada curso tem seus detalhes como , data de inicio, carga horaria e valor");
		System.out.println("");
		System.out.println("Vers�es");
		System.out.println("\tV1.0 - Cadastros,relat�rios, 1 regra de neg�cio");
		System.out.println("=======================================================================");

	}

}