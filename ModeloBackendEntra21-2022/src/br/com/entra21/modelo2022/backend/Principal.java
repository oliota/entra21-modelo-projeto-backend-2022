package br.com.entra21.modelo2022.backend;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import br.com.entra21.modelo2022.backend.anottations.FaltaImplementar;
import br.com.entra21.modelo2022.backend.area.logada.MenuPrincipal;
import br.com.entra21.modelo2022.backend.area.logada.cadastros.crud.FuncionarioCRUD;
import br.com.entra21.modelo2022.backend.exceptions.FuncionarioExistenteException;
import br.com.entra21.modelo2022.backend.exceptions.SenhaIncorretaException;
import br.com.entra21.modelo2022.backend.modelos.Funcionario;

public class Principal {

	static Scanner entrada = new Scanner(System.in);

	public static Funcionario funcionarioLogado = null;
	
	//TODO 03-avançado anotações
	@FaltaImplementar
	public static void entrar(byte tentativa) {
		if (tentativa == 0) {
			System.out.println("Não foi possivel realizar o login, todas as tentativas falharam");
			return;
		} else {
			//TODO 01-logica operador ternario
			System.out.println((tentativa > 1 ? "Restam " : "Resta ") + tentativa
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de login:");
		}
		try {
			System.out.println("Informe o CPF do funcionario:");
			Funcionario funcionario = IRepositorio.funcionarios.get(entrada.next().trim());

			System.out.println("Funcionario encontrado :" + funcionario.getNome());
			System.out.println("Informe a senha para liberar o acesso:");

			if (!funcionario.getSenha().equals(entrada.next())) {
				throw new SenhaIncorretaException();//TODO 03-avançado custom Exception
			} else {
				verificarSenha(funcionario);
				return;
			}
		} catch (NullPointerException e) {
			System.out.println("Nenhum funcionario encontrado com esse CPF");
			entrar(--tentativa);//TODO 03-logica decremento
			return;
		} catch (SenhaIncorretaException e) {
			System.out.println(e.getMessage());
			entrar(--tentativa);
			return;
		}

	}

	@FaltaImplementar
	public static void cadastrar(byte tentativa) {

		String cpf;

		if (tentativa == 0) {
			System.out.println("Não foi possivel realizar o cadastro, todas as tentativas falharam");
			return;
		} else {
			System.out.println((tentativa > 1 ? "Restam " : "Resta ") + tentativa
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de cadastro:");
		}
		try {
			System.out.println("Informe o CPF do novo funcionario:");
			cpf = entrada.next().trim();
			Funcionario funcionario = IRepositorio.funcionarios.get(cpf);

			if (funcionario != null) {
				throw new FuncionarioExistenteException();
			} else {
				funcionario = new FuncionarioCRUD().capturarValores();
				funcionario.setCpf(cpf); 
				funcionario.setSenha(cpf); 
				IRepositorio.funcionarios.put(cpf, funcionario);
				System.out.println("Funcionário cadastrado, por favor realize o login:");
				System.out.println("IMPORTANTE: No primeiro acesso a senha é igual ao CPF e será solicitado a mudança");
				return;
			}

		
		} catch (FuncionarioExistenteException e) {
			System.out.println(e.getMessage());
			cadastrar(--tentativa);
			return;
		}

	}

	@FaltaImplementar
	public static void recuperarSenha(byte tentativa) {

		if (tentativa == 0) {
			System.out.println("Não foi possivel realizar a recuperação de senha, todas as tentativas falharam");
			return;
		} else {
			System.out.println((tentativa > 1 ? "Restam " : "Resta ") + tentativa
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de recuperação de senha:");
		}
		try {
			System.out.println("Informe o CPF do funcionario:");
			Funcionario funcionario = IRepositorio.funcionarios.get(entrada.next().trim());

			System.out.println("Funcionario encontrado :" + funcionario.getNome());
			funcionario.setSenha(funcionario.getDataAdmissao().format( DateTimeFormatter.ofPattern("dd/MM/YYYY"))); 
			IRepositorio.funcionarios.put(funcionario.getCpf(), funcionario);
			System.out.println("A senha foi atualizada com a data do admissão no formato DD/MM/YYYY:");
			
			System.out.println("Funcionário atualizado, por favor realize o login:");
			
		} catch (NullPointerException e) {
			System.out.println("Nenhum funcionario encontrado com esse CPF");
			recuperarSenha(--tentativa);
			return;
		} 
	}

	private static void verificarSenha(Funcionario funcionario) {

		if (funcionario.getSenha().equals(funcionario.getCpf()) || funcionario.getSenha().equals(funcionario.getDataAdmissao().format( DateTimeFormatter.ofPattern("dd/MM/YYYY")))) {
			atualizarSenha(funcionario); 
			IRepositorio.funcionarios.size();
		} else {
			definirFuncionarioLogado(funcionario);
			
			new MenuPrincipal("PRINCIPAL", new ArrayList<String>(Arrays.asList("Cadastros", "Relatórios","Comercial")))
					.executarMenu(); 
			
			definirFuncionarioLogado(null);
		}

	}

	private static void definirFuncionarioLogado(Funcionario funcionario) {

		if(funcionario!=null) {
			System.out.println("Bem vindo, "+funcionario.getNome());
		}else {
			System.out.println("Até a proxima "+funcionarioLogado.getNome()+", volte sempre que precisar.");
		}
		funcionarioLogado=funcionario;
		
	}

	private static void atualizarSenha(Funcionario funcionario) {

		System.out.println("Atualize a sua senha, pois não é seguro manter a senha igual ao cpf ou com a data de admissão:");
		funcionario.setSenha(entrada.next());
		verificarSenha(funcionario);

	}

	public static void exibirInformacoesSobre() {
		System.out.println("============================== SOBRE ==================================");
		System.out.println("Projeto desenvolvido pela EU-quipe Oliota");
		System.out.println("Objetivo");
		System.out.println(
				"\tServir de modelo para construção dos projetos em grupo para os alunos do entra21-2022 (Melhor turma de java)");
		System.out.println(
				"\tEm cada etapa o projeto será atualizado e salvo em branches diferentes para manter o historico de evolução");
		System.out.println("");
		System.out.println("Escopo");
		System.out.println(
				"\tProjeto para cadastro, relatórios e regras de negocios envolvendo o assunto GESTOR DE CURSOS");
		System.out.println(
				"\tO catalogo de cursos é oferecido pela instituição e os clientes optam por adquirir os cursos");
		System.out.println("\tCada curso tem seus detalhes como , data de inicio, carga horaria e valor");
		System.out.println("");
		System.out.println("Versões");
		System.out.println("\tV1.0 - Cadastros,relatórios, 1 regra de negócio");
		System.out.println("=======================================================================");

	}

}
