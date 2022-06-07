package br.com.entra21.modelo2022.backend.area.logada;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.entra21.modelo2022.backend.Menu;
import br.com.entra21.modelo2022.backend.area.logada.cadastros.MenuCadastro;

public class MenuPrincipal extends Menu {

	public MenuPrincipal(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes); 
	}
	
	@Override
	public byte capturarOpcao() {

		byte opcao = super.capturarOpcao();
		switch (opcao) {
		case 1: 

			new MenuCadastro("CADASTROS", new ArrayList<String>(Arrays.asList("Cursos", "Clientes"))).executarMenu(); 
			break;
		case 2:  
		//	new MenuPrincipal("RELAT�RIOS", new ArrayList<String>(Arrays.asList("Anivers�riantes", "Ranking de cursos"))).executarMenu(); 
			break; 
		default:
			System.out.println("Op��o inv�lida para o menu de " + super.getTitulo());
			break;
		}
		return opcao;
	}

}