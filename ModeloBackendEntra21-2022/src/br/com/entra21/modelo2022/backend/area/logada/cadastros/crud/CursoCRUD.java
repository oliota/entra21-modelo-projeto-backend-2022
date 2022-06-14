package br.com.entra21.modelo2022.backend.area.logada.cadastros.crud;
 
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import br.com.entra21.modelo2022.backend.Menu;
import br.com.entra21.modelo2022.backend.Repositorio;
import br.com.entra21.modelo2022.backend.modelos.Curso;

public class CursoCRUD extends Menu implements ICrud<Curso> {

	private HashMap<String,Curso> lista = Repositorio.cursos;
	private DateTimeFormatter dataFormater= DateTimeFormatter.ofPattern("dd/MM/YYYY"); 
	private DateTimeFormatter horaFormater= DateTimeFormatter.ofPattern("hh:mm:ss"); 
	private final String TABULACAO = "\t\t\t";
 
	
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
	public void listar(HashMap<String,Curso> lista) {
		System.out.println("------------  LISTA " + getTitulo() + "  ----------------");
		for (Curso curso : lista.values()) {
			System.out.println("CHAVE:"+curso.getNome()+TABULACAO+curso.getValor()+"\tInicio:"+dataFormater.format(curso.getDataInicio()));
		}
		System.out.println("------------  QUANTIDADE (" + lista.size() + ")  -----------");

	}

	@Override
	public void adicionar() {
		Curso novo = capturarValores();
		if (buscar(novo) == null) {
			lista.put(novo.getNome(),novo);
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
			lista.put(chave.getNome(),capturarValores()) ;
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
		System.out.println("Informe a CHAVE"  );
		formulario.setNome(super.getEntrada().next());
		return formulario;
	}

	@Override
	public Curso capturarValores() {
		Curso formulario = new Curso();
		
		System.out.println("Informe o nome" );
		formulario.setNome(super.getEntrada().next());

		System.out.println("Informe o valor:");
		formulario.setValor(super.getEntrada().nextDouble());
		
		return formulario;
	}

	@Override
	public void exibirDetalhes(Curso completo) {
		if(completo==null) {
			System.out.println("Não é possivel exibir os detalhes, item não localizado");
		}else {
			System.out.println(completo.toString()); 
		}
		
	}

}
