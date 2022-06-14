package br.com.entra21.modelo2022.backend.area.logada.cadastros.crud;
 

import static br.com.entra21.modelo2022.backend.area.logada.cadastros.crud.ICrud.opcoes;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import br.com.entra21.modelo2022.backend.Menu;
import br.com.entra21.modelo2022.backend.Repositorio;
import br.com.entra21.modelo2022.backend.modelos.Funcionario;

public class FuncionarioCRUD extends Menu implements ICrud<Funcionario> {

	private HashMap<String, Funcionario> lista = Repositorio.funcionarios;
	private final String TABULACAO = "\t\t\t";

	public FuncionarioCRUD() {
		super("CLIENTES", opcoes);
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
	public void listar(HashMap<String, Funcionario> lista) {
		System.out.println("------------  LISTA " + getTitulo() + "  ----------------");
		for (Funcionario funcionario : lista.values()) {
			System.out.println("CHAVE:"+funcionario.getCpf()+TABULACAO + funcionario.getNome() + " - " + funcionario.getIdade() + " - " + funcionario.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
		}
		System.out.println("------------  QUANTIDADE (" + lista.size() + ")  -----------");

	}

	@Override
	public void adicionar() {
		Funcionario novo = capturarValores();
		if (buscar(novo) == null) {
			lista.put(novo.getNome(), novo);
		} else {
			System.out.println("Já existe um registro com CHAVE:" + novo.getCpf());
		}

	}

	@Override
	public Funcionario buscar(Funcionario chave) {
		return lista.get(chave.getNome());

	}

	@Override
	public void editar(Funcionario chave) {
		Funcionario funcionario = buscar(chave);
		if (funcionario == null) {
			System.out.println("Não existe um registro com CHAVE:" + chave.getCpf());
		} else {
			lista.put(chave.getNome(), capturarValores());
			System.out.println("Dados atualizados");
		}
	}

	@Override
	public void deletar(Funcionario chave) {
		Funcionario funcionario = buscar(chave);
		if (funcionario == null) {
			System.out.println("Não existe um registro com CHAVE:" + chave.getCpf());
		} else {
			lista.remove(chave.getNome());
			System.out.println("Item excluido");
		}

	}

	@Override
	public Funcionario capturarChave() {
		Funcionario formulario = new Funcionario();
		System.out.println("Informe a CHAVE");
		formulario.setNome(super.getEntrada().next());
		return formulario;
	}

	@Override
	public Funcionario capturarValores() {
		Funcionario formulario = new Funcionario();

		System.out.println("Informe o nome");
		formulario.setNome(super.getEntrada().next());

		System.out.println("Informe a idade:");
		formulario.setIdade(super.getEntrada().nextByte());

		return formulario;
	}

	@Override
	public void exibirDetalhes(Funcionario completo) {
		if(completo==null) {
			System.out.println("Não é possivel exibir os detalhes, item não localizado");
		}else {
			System.out.println(completo.toString()); 
		}
		
	}

	
	
}
