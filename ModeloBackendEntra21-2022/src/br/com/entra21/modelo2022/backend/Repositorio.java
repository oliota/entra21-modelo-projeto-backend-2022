package br.com.entra21.modelo2022.backend;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import br.com.entra21.modelo2022.backend.modelos.Cliente;
import br.com.entra21.modelo2022.backend.modelos.Curso;

public class Repositorio {

	public static HashMap<String, Curso> cursos = new HashMap<>();
	public static HashMap<String, Cliente> clientes = new HashMap<>();

	public static void gerarMassaTeste() {

		
		inicializarCursos();
		 

		clientes.put("001", new Cliente("Fulano", (byte) 32, "001"));
		clientes.put("002", new Cliente("Fulano", (byte) 32, "002"));
		clientes.put("003", new Cliente("Fulano", (byte) 32, "003"));
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
	
	 

}
