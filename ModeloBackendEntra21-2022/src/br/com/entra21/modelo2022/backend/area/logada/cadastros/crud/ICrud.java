package br.com.entra21.modelo2022.backend.area.logada.cadastros.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public interface ICrud<T> {

	ArrayList<String> opcoes = new ArrayList<String>(
			Arrays.asList("Listar", "Adicionar", "Buscar", "Editar", "Deletar"));

	public void listar(HashMap<String,T> lista);

	public void adicionar();

	public T buscar(T chave);

	public void editar(T chave);

	public void deletar(T chave);

	public T capturarChave();

	public T capturarValores();
	
	public void exibirDetalhes(T completo);

}
