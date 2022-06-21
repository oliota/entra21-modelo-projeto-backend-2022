package br.com.entra21.modelo2022.backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import br.com.entra21.modelo2022.backend.modelos.Cliente;
import br.com.entra21.modelo2022.backend.modelos.Compra;
import br.com.entra21.modelo2022.backend.modelos.Curso;
import br.com.entra21.modelo2022.backend.modelos.Funcionario;

public interface IRepositorio {

	public Tradutor tradutor = Tradutor.INGLES;
	public HashMap<String, Curso> cursos = new HashMap<>();
	public HashMap<String, Funcionario> funcionarios = new HashMap<>();
	public HashMap<String, Cliente> clientes = new HashMap<>();
	public HashMap<String, Compra> compras = new HashMap<>();

	public static void gerarMassaTeste() {

		inicializarCursos();
		inicializarFuncionarios();
		inicialiarClientes();
		inicializarCompras();

	}

	private static void inicializarCompras() {

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-YYYY-hh-mm");

		HashMap<String, Curso> apenasUmCurso = new HashMap<>();
		apenasUmCurso.put(cursos.get("Metodologia �gil").getNome(), cursos.get("Metodologia �gil"));

		HashMap<String, Curso> poucosCursos = new HashMap<>();
		poucosCursos.put(cursos.get("Metodologia �gil").getNome(), cursos.get("Metodologia �gil"));
		poucosCursos.put(cursos.get("Git").getNome(), cursos.get("Git"));

		HashMap<String, Curso> muitosCursos = new HashMap<>();
		muitosCursos.put(cursos.get("Metodologia �gil").getNome(), cursos.get("Metodologia �gil"));
		muitosCursos.put(cursos.get("Git").getNome(), cursos.get("Git"));
		muitosCursos.put(cursos.get("L�gica de programa��o").getNome(), cursos.get("L�gica de programa��o"));

		Compra compraPequena = new Compra("001", "001", apenasUmCurso);
		compraPequena.setDataCompra(LocalDateTime.of(2022, 6, 13, 14, 0));
		compras.put(compraPequena.getDataCompra().format(formatador), compraPequena);

		Compra compraMedia = new Compra("001", "002", poucosCursos);
		compraMedia.setDataCompra(LocalDateTime.of(2022, 6, 14, 18, 0));
		compraMedia.setDataCancelado(LocalDateTime.of(2022, 6, 15, 18, 0));
		compras.put(compraMedia.getDataCompra().format(formatador), compraMedia);

		Compra compraGrande = new Compra("001", "003", muitosCursos);
		compraGrande.setDataCompra(LocalDateTime.of(2022, 6, 10, 10, 0));
		compras.put(compraGrande.getDataCompra().format(formatador), compraGrande);

	}

	private static void inicializarCursos() {

		LocalTime horaInicioNoite = LocalTime.of(18, 15);
		LocalTime horaFimNoite = LocalTime.of(22, 15);

		cursos.put("Metodologia �gil", // chave
				// value
				new Curso("Metodologia �gil", new String[] {}, // pre-requisitos
						800, // valor
						LocalDate.of(2022, 04, 01), LocalDate.of(2022, 04, 04), // datas
						horaInicioNoite, horaFimNoite, // horarios
						new HashSet<String>(Arrays.asList("Scrum", "Kanban")), // ementa
						new String[][] { // plano de aulas
								{ "Conceitos sobre Scrum", "Papeis", "Cerimonias", "Artefatos" }, // 1� aula
								{ "Conceitos sobre Kanban", "Trello", "Colunas importantes" }, // 2� aula
						}//
				));

		cursos.put("Git", // chave
				// value
				new Curso("Git", new String[] {}, // pre-requisitos
						200, // valor
						LocalDate.of(2022, 04, 05), LocalDate.of(2022, 04, 10), // datas
						horaInicioNoite, horaFimNoite, // horarios
						new HashSet<String>(Arrays.asList("Configura��o", "Reposit�rios", "Commit e Push", "Branches")), // ementa
						new String[][] { // plano de aulas
								{ "Conceitos sobre Git", "Configura��o", "Reposit�rios", "Clone","Commit","Push","Branches" }, // 1� aula
						}//
				));

		cursos.put("L�gica de programa��o", // chave
				// value
				new Curso("L�gica de programa��o", new String[] { "Git" }, // pre-requisitos
						1000, // valor
						LocalDate.of(2022, 04, 11), LocalDate.of(2022, 04, 21), // datas
						horaInicioNoite, horaFimNoite, // horarios
						new HashSet<String>(
								Arrays.asList("Variaveis", "Constantes", "Decis�es", "Repeti��es", "Fun��o")), // ementa
						new String[][] { // plano de aulas
								{ "Configugar ambiente", "Primeiro programa", "Variaveis", "Syso" }, // 1� aula
								{ "Constantes", "Intera��o com usu�rio", "Coment�rios" }, // 2� aula
						}//
				));

		cursos.put("Java avan�ado", // chave
				// value
				new Curso("Java avan�ado", new String[] { "L�gica de programa��o" }, // pre-requisitos
						600, // valor
						LocalDate.of(2022, 04, 22), LocalDate.of(2022, 04, 30), // datas
						horaInicioNoite, horaFimNoite, // horarios
						new HashSet<String>(
								Arrays.asList("Wrappers", "Enum", "Collection", "Anottations", "Tratamento de erros")), // ementa
						new String[][] { // plano de aulas
								{ "Classes Wrapper", "Enum", "Exercicios" }, // 1� aula
								{ "Collections", "List", "ArrayList","LinkedList" }, // 2� aula
								{ "Anottations", "Datas java8" }, // 3� aula
						}//
				));

	}

	private static void inicialiarClientes() {

		clientes.put("001", new Cliente("Jos�", (byte) 32, "001"));
		clientes.put("002", new Cliente("Maria", (byte) 32, "002"));
		clientes.put("003", new Cliente("Jo�o", (byte) 32, "003"));

	}

	private static void inicializarFuncionarios() {
		Funcionario admin = new Funcionario("Admin", (byte) 32, "001");
		admin.setSenha("123");
		funcionarios.put("001", admin);

		funcionarios.put("002", new Funcionario("Dono", (byte) 32, "002"));
		funcionarios.put("003", new Funcionario("Estagiario", (byte) 32, "003"));

	}

}
