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

public class Repositorio {

	public static HashMap<String, Curso> cursos = new HashMap<>();
	public static Funcionario funcionarioLogado;
	public static HashMap<String, Funcionario> funcionarios = new HashMap<>();
	public static HashMap<String, Cliente> clientes = new HashMap<>();
	public static HashMap<String, Compra> compras = new HashMap<>();

	public static void gerarMassaTeste() {

		
		inicializarCursos();
		inicializarFuncionarios();
		inicialiarClientes();
		inicializarCompras();
		 

	}
 



	private static void inicializarCompras() {
		HashMap<String, Curso> apenasUmCurso=new HashMap<>();
		apenasUmCurso.put(cursos.get("Metodologia ágil").getNome(), cursos.get("Metodologia ágil"));

		HashMap<String, Curso> poucosCursos=new HashMap<>();
		poucosCursos.put(cursos.get("Metodologia ágil").getNome(), cursos.get("Metodologia ágil"));
		poucosCursos.put(cursos.get("Git").getNome(), cursos.get("Git"));
		

		HashMap<String, Curso> muitosCursos=new HashMap<>();
		muitosCursos.put(cursos.get("Metodologia ágil").getNome(), cursos.get("Metodologia ágil"));
		muitosCursos.put(cursos.get("Git").getNome(), cursos.get("Git"));
		muitosCursos.put(cursos.get("Lógica de programação").getNome(), cursos.get("Lógica de programação"));
		

		Compra compraPequena = new Compra("001","001", apenasUmCurso);
		compraPequena.setDataCompra(LocalDateTime.of(2022, 6, 13, 14, 0));
		compras.put(compraPequena.getDataCompra().format(DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm")), compraPequena);
		
		Compra compraMedia = new Compra("001","002", poucosCursos);
		compraMedia.setDataCompra(LocalDateTime.of(2022, 6, 14, 18, 0));
		compraMedia.setDataCancelado(LocalDateTime.of(2022, 6, 15, 18, 0));
		compras.put(compraMedia.getDataCompra().format(DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm")), compraMedia);
		
		Compra compraGrande = new Compra("001","003", muitosCursos);
		compraGrande.setDataCompra(LocalDateTime.of(2022, 6, 10, 10, 0));
		compras.put(compraGrande.getDataCompra().format(DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm")), compraGrande);
		
	}




	private static void inicializarCursos() {

		LocalTime horaInicioNoite=LocalTime.of(18, 15);
		LocalTime horaFimNoite=LocalTime.of(18, 15);
		
		
		cursos.put("Metodologia ágil",
				new Curso("Metodologia ágil", new String[] {"Nenhum"}, 800, LocalDate.of(2022, 04, 01),
						LocalDate.of(2022, 04, 04),horaInicioNoite, horaFimNoite,
						new HashSet<String>(Arrays.asList("Scrum", "Kanban"))));
		

		cursos.put("Git",
				new Curso("Git", new String[] {}, 200, LocalDate.of(2022, 04, 05),
						LocalDate.of(2022, 04, 10), horaInicioNoite,horaFimNoite,
						new HashSet<String>(Arrays.asList("Configuração", "Repositórios","Commit e Push","Branches"))));
		

		cursos.put("Lógica de programação",
				new Curso("Lógica de programação", new String[] {}, 1000, LocalDate.of(2022, 04, 11),
						LocalDate.of(2022, 04, 21), horaInicioNoite,horaFimNoite,
						new HashSet<String>(Arrays.asList("Variaveis", "Constantes","Decisões","Repetições","Função"))));
		
		cursos.put("Java avançado",
				new Curso("Java avançado", new String[] {}, 600, LocalDate.of(2022, 04, 22),
						LocalDate.of(2022, 04, 30), horaInicioNoite,horaFimNoite,
						new HashSet<String>(Arrays.asList("Wrappers", "Enum","Collection","Anottations","Tratamento de erros"))));
		
	}
	
	private static void inicialiarClientes() {

		clientes.put("001", new Cliente("José", (byte) 32, "001"));
		clientes.put("002", new Cliente("Maria", (byte) 32, "002"));
		clientes.put("003", new Cliente("João", (byte) 32, "003"));
		
	} 
	
	private static void inicializarFuncionarios() {
		Funcionario admin=new Funcionario("Admin", (byte) 32, "001");
		admin.setSenha("123");
		funcionarios.put("001",admin );
		
		funcionarios.put("002", new Funcionario("Dono", (byte) 32, "002"));
		funcionarios.put("003", new Funcionario("Estagiario", (byte) 32, "003"));
		
	}


}
