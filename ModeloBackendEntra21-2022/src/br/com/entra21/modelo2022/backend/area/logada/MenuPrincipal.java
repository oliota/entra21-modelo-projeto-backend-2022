package br.com.entra21.modelo2022.backend.area.logada;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.entra21.modelo2022.backend.Menu;
import br.com.entra21.modelo2022.backend.area.logada.cadastros.MenuCadastro;
import br.com.entra21.modelo2022.backend.area.logada.cadastros.MenuComercial;
import br.com.entra21.modelo2022.backend.area.logada.cadastros.MenuRelatorio;

public class MenuPrincipal extends Menu {

	public MenuPrincipal(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes); 
	}
	
	@Override
	public byte capturarOpcao() {

		byte opcao = super.capturarOpcao();
		switch (opcao) {
		case 1: 

			new MenuCadastro("CADASTROS", new ArrayList<String>(Arrays.asList("Cursos", "Clientes","Funcionarios"))).executarMenu(); 
			break;
		case 2:  
			new MenuRelatorio("RELATÓRIOS", new ArrayList<String>(Arrays.asList("Tempo de casa","Funcionários Aniversáriantes", "Ranking de cursos"))).executarMenu(); 
			break; 
		case 3:
			new MenuComercial("COMERCIAL", new ArrayList<String>(Arrays.asList("Ver catalogo de cursos","Realizar venda", "Realizar cancelamento","Histórico de compras"))).executarMenu(); 
		default:
			System.out.println("Opção inválida para o menu de " + super.getTitulo());
			break;
		}
		return opcao;
	}

 

}
