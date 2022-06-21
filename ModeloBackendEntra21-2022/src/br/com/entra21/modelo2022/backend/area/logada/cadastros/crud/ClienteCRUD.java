package br.com.entra21.modelo2022.backend.area.logada.cadastros.crud;
 

import java.util.HashMap;

import br.com.entra21.modelo2022.backend.IRepositorio;
import br.com.entra21.modelo2022.backend.Menu; 
import br.com.entra21.modelo2022.backend.modelos.Cliente;

public class ClienteCRUD extends Menu implements ICrud<Cliente> {

	private HashMap<String, Cliente> lista = IRepositorio.clientes;
	private final String TABULACAO = "\t\t\t";

	public ClienteCRUD() {
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
	public void listar(HashMap<String, Cliente> lista) {
		System.out.println("------------  LISTA " + getTitulo() + "  ----------------");
		for (Cliente cliente : lista.values()) {
			System.out.println("CHAVE:"+cliente.getCpf()+TABULACAO + cliente.getNome() + " - " + cliente.getIdade() );
		}
		System.out.println("------------  QUANTIDADE (" + lista.size() + ")  -----------");

	}

	@Override
	public void adicionar() {
		Cliente novo = capturarValores();
		if (buscar(novo) == null) {
			lista.put(novo.getNome(), novo);
		} else {
			System.out.println("Já existe um registro com CHAVE:" + novo.getCpf());
		}

	}

	@Override
	public Cliente buscar(Cliente chave) {
		return lista.get(chave.getNome());

	}

	@Override
	public void editar(Cliente chave) {
		Cliente cursoAtual = buscar(chave);
		if (cursoAtual == null) {
			System.out.println("Não existe um registro com CHAVE:" + chave.getCpf());
		} else {
			lista.put(chave.getNome(), capturarValores());
			System.out.println("Dados atualizados");
		}
	}

	@Override
	public void deletar(Cliente chave) {
		Cliente cursoAtual = buscar(chave);
		if (cursoAtual == null) {
			System.out.println("Não existe um registro com CHAVE:" + chave.getCpf());
		} else {
			lista.remove(chave.getNome());
			System.out.println("Item excluido");
		}

	}

	@Override
	public Cliente capturarChave() {
		Cliente formulario = new Cliente();
		System.out.println("Informe a CHAVE");
		formulario.setNome(super.getEntrada().next());
		return formulario;
	}

	@Override
	public Cliente capturarValores() {
		Cliente formulario = new Cliente();

		System.out.println("Informe o nome");
		formulario.setNome(super.getEntrada().next());

		System.out.println("Informe a idade:");
		formulario.setIdade(super.getEntrada().nextByte());

		return formulario;
	}

	@Override
	public void exibirDetalhes(Cliente completo) {
		if(completo==null) {
			System.out.println("Não é possivel exibir os detalhes, item não localizado");
		}else {
			System.out.println(completo.toString()); 
		}
		
	}

	
	
}
