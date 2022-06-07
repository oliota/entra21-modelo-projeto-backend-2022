package br.com.entra21.modelo2022.backend.area.logada.cadastros;

import java.util.ArrayList; 

import br.com.entra21.modelo2022.backend.Menu;
import br.com.entra21.modelo2022.backend.area.logada.cadastros.crud.ClienteCRUD;
import br.com.entra21.modelo2022.backend.area.logada.cadastros.crud.CursoCRUD; 

public class MenuCadastro extends Menu {

	public MenuCadastro(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes); 
	}
	
	@Override
	public byte capturarOpcao() {

		byte opcao = super.capturarOpcao();
		switch (opcao) {
		case 1:  
			new CursoCRUD().executarMenu(); 
			break;
		case 2: 
			new ClienteCRUD().executarMenu(); 
			break;
		case 3: 
			break;
		case 4: 
			break; 
		default:
			System.out.println("Op��o inv�lida para o menu de " + super.getTitulo());
			break;
		}
		return opcao;
	}

}

