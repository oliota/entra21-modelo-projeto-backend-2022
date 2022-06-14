package br.com.entra21.modelo2022.backend.area.logada.cadastros;

import java.util.ArrayList;

import br.com.entra21.modelo2022.backend.Menu;
import br.com.entra21.modelo2022.backend.anottations.FaltaImplementar;
import br.com.entra21.modelo2022.backend.anottations.Lembrete;

public class MenuRelatorio extends Menu {

	public MenuRelatorio(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);
	}

	@Override
	public byte capturarOpcao() {

		byte opcao = super.capturarOpcao();
		switch (opcao) {
		case 1:
			listarTempoDeCasa();
			break;
		case 2:
			listarFuncionariosAniversariantes();
			break;
		case 3:
			listarCursosMaisVendidos();
			break;
		}
		return opcao;
	}

	@FaltaImplementar
	@Lembrete(value = "Utilizar Lambda")
	private void listarTempoDeCasa() {
		System.out.println("Ainda não fiz, tenha CALMA!!!");

	}

	@FaltaImplementar
	@Lembrete(value = "Utilizar Lambda")
	private void listarFuncionariosAniversariantes() {
		System.out.println("Ainda não fiz, tenha CALMA!!!");

	}

	@FaltaImplementar
	@Lembrete(value = "Utilizar Lambda")
	private void listarCursosMaisVendidos() {
		System.out.println("Ainda não fiz, tenha CALMA!!!");

	}

}
