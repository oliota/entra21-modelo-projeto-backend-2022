package br.com.entra21.modelo2022.backend.area.logada.cadastros.crud;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.HashMap;
import java.util.Scanner;

import br.com.entra21.modelo2022.backend.IRepositorio;
import br.com.entra21.modelo2022.backend.Menu;
import br.com.entra21.modelo2022.backend.modelos.Curso;

public class CursoCRUD extends Menu implements ICrud<Curso> {

	private HashMap<String, Curso> lista = IRepositorio.cursos;
	private DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private DateTimeFormatter timeFormater = DateTimeFormatter.ofPattern("HH:mm");
	private final String TABULACAO = "\t\t";

	public CursoCRUD() {
		super("CURSOS", opcoes);
	}

	@Override
	public byte capturarOpcao() {

		byte opcao = super.capturarOpcao();
		switch (opcao) {
		case 1:
			listar(lista);
			break;
		case 2:
			adicionar();
			break;
		case 3:
			exibirDetalhes(buscar(capturarChave()));
			break;
		case 4:
			editar(capturarChave());
			break;
		case 5:
			deletar(capturarChave());
			break;
		}
		return opcao;
	}

	@Override
	public void listar(HashMap<String, Curso> lista) {
		System.out.println("------------  LISTA " + getTitulo() + "  ----------------");
		for (Curso curso : lista.values()) {
			System.out.println("CHAVE:" + curso.getNome() + TABULACAO + curso.getValor() + "\tInicio:"
					+ dateFormater.format(curso.getDataInicio()));
		}
		System.out.println("------------  QUANTIDADE (" + lista.size() + ")  -----------");

	}

	@Override
	public void adicionar() {
		Curso novo = capturarValores();
		if (buscar(novo) == null) {
			lista.put(novo.getNome(), novo);
		} else {
			System.out.println("Já existe um registro com CHAVE:" + novo.getNome());
		}

	}

	@Override
	public Curso buscar(Curso chave) {
		return lista.get(chave.getNome());

	}

	@Override
	public void editar(Curso chave) {
		Curso cursoAtual = buscar(chave);
		if (cursoAtual == null) {
			System.out.println("Não existe um registro com CHAVE:" + chave.getNome());
		} else {
			lista.put(chave.getNome(), capturarValores());
			System.out.println("Dados atualizados");
		}
	}

	@Override
	public void deletar(Curso chave) {
		Curso cursoAtual = buscar(chave);
		if (cursoAtual == null) {
			System.out.println("Não existe um registro com CHAVE:" + chave.getNome());
		} else {
			lista.remove(chave.getNome());
			System.out.println("Item excluido");
		}

	}

	@Override
	public Curso capturarChave() {
		Curso formulario = new Curso();
		System.out.println("Informe a CHAVE");
		formulario.setNome(new Scanner(System.in).useDelimiter("\r\n").next());
		return formulario;
	}

	@Override
	public Curso capturarValores() {
		Curso formulario = new Curso();

		System.out.println("Informe o nome");
		formulario.setNome(new Scanner(System.in).useDelimiter("\r\n").next());

		System.out.println("Informe o valor:");
		formulario.setValor(super.getEntrada().nextDouble());

		System.out.println("Informe a data de inicio no formato dd/mm/yyyy:");

		// fazendo etapa por etapa
		System.out.println("Informe a data de inicio no formato dd/mm/yyyy:");
		String textoCapturado = super.getEntrada().next(); // 1º - recebe a data no formato esperado
		TemporalAccessor temporal = dateFormater.parse(textoCapturado);// 2º converte em TemporalAccessor com base no
																		// formato
		// capturado
		LocalDate dataInico = LocalDate.from(temporal);// 3º converte em LocalDate

		formulario.setDataInicio(dataInico);

		// fazendo de forma encadeada
		System.out.println("Informe a data de fim no formato dd/mm/yyyy:");
		formulario.setDataFim(LocalDate.from( // 3º converte em LocalDate
				dateFormater.parse(// 2º converte em TemporalAccessor com base no formato capturado
						super.getEntrada().next()// 1º - recebe a data no formato esperado
				)));

	 
 
		System.out.println("Informe a hora de inicio no formato 24horas HH/mm:");
		formulario.setHoraInicio(LocalTime.from( // 3º converte em LocalTime
				timeFormater.parse(// 2º converte em TemporalAccessor com base no formato capturado
						super.getEntrada().next()// 1º - recebe a hora no formato esperado
				)));
		
		System.out.println("Informe a hora de inicio no formato 24horas HH/mm:");
		formulario.setHoraFim(LocalTime.from( // 3º converte em LocalTime
				timeFormater.parse(// 2º converte em TemporalAccessor com base no formato capturado
						super.getEntrada().next()// 1º - recebe a hora no formato esperado
				)));

		return formulario;
	}

	@Override
	public void exibirDetalhes(Curso completo) {
		if (completo == null) {
			System.out.println("Não é possivel exibir os detalhes, item não localizado");
		} else {
			System.out.println(completo.toString());
		}

	}

}
