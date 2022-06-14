package br.com.entra21.modelo2022.backend.area.logada.cadastros;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import br.com.entra21.modelo2022.backend.Menu;
import br.com.entra21.modelo2022.backend.Repositorio;
import br.com.entra21.modelo2022.backend.anottations.Lembrete;
import br.com.entra21.modelo2022.backend.area.logada.cadastros.crud.ClienteCRUD;
import br.com.entra21.modelo2022.backend.area.logada.cadastros.crud.CursoCRUD;
import br.com.entra21.modelo2022.backend.exceptions.ClienteNaoLocalizadoException;
import br.com.entra21.modelo2022.backend.exceptions.CompraJaCanceladaException;
import br.com.entra21.modelo2022.backend.exceptions.CompraNaoEfetuadaException;
import br.com.entra21.modelo2022.backend.exceptions.CompraNaoLocalizadoException;
import br.com.entra21.modelo2022.backend.modelos.Cliente;
import br.com.entra21.modelo2022.backend.modelos.Compra;
import br.com.entra21.modelo2022.backend.modelos.Curso;

public class MenuComercial extends Menu {

	private ClienteCRUD clienteCRUD;
	private CursoCRUD cursoCRUD;
	private final String TABULACAO = "\t\t\t";

	public MenuComercial(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);
		clienteCRUD = new ClienteCRUD();
		cursoCRUD = new CursoCRUD();
	}

	@Override
	public byte capturarOpcao() {

		byte opcao = super.capturarOpcao();
		switch (opcao) {
		case 1:
			new CursoCRUD().listar(Repositorio.cursos);
			break;
		case 2:
			realizarCompra();
			break;
		case 3:
			realizarCancelamento();
			break;
		case 4:
			listarHistoricoCompras();
			break;
		}
		return opcao;
	}

	@Lembrete(value="Não está localizando bem pela chave no formato de data e hora")
	private void realizarCancelamento() {
		try {
			Scanner entrada = new Scanner(System.in);

			System.out.println("================== Realizando cancelamento =============");
			listarHistoricoCompras();
			System.out.println("Informe a CHAVE");
			Compra compra = Repositorio.compras.get(entrada.next());
			if (compra == null) {
				throw new CompraNaoLocalizadoException();
			} else if(compra.getDataCancelado()!=null){
				throw new CompraJaCanceladaException();
			}else {
				compra.setDataCancelado(LocalDateTime.now());
				
			}
			Repositorio.compras.put(compra.getDataCompra().format(DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm")),
					compra);
			System.out.println("Compra cancelada com sucesso");
		} catch (CompraNaoLocalizadoException e) {
			System.out.println("A compra não foi cancelada, motivo: " + e.getMessage());
		} catch (CompraJaCanceladaException e) {
			System.out.println("A compra não foi cancelada, motivo: " + e.getMessage());
		}
	}

	private void realizarCompra() {
		try {
			Scanner entrada = new Scanner(System.in);

			System.out.println("================== Realizando compra =============");
			clienteCRUD.listar(Repositorio.clientes);

			Cliente cliente = clienteCRUD.buscar(clienteCRUD.capturarChave());
			if (cliente == null) {
				throw new ClienteNaoLocalizadoException();
			}
			System.out.println("Cliente selecionado: " + cliente.getNome());

			System.out.println("Escolha um ou vários cursos para comprar:");
			cursoCRUD.listar(Repositorio.cursos);

			String chave;
			String resposta = null;
			HashMap<String, Curso> cursos = new HashMap<>();
			do {

				Curso curso = cursoCRUD.buscar(cursoCRUD.capturarChave());
				if (curso != null) {
					cursos.put(curso.getNome(), curso);
				} else {
					System.out.println("Curso não localizado, tente novamente.");
					resposta = "S";
					continue;
				}
				if (cursos.isEmpty()) {
					System.out.println("A compra deve ter no minimo 1 curso");
					resposta = "S";
					continue;
				} else {
					System.out.println("Curso inserido na lista de compra, deseja selecionar mais outro curso?(S/N)");
					resposta = entrada.next();
				}

			} while (resposta.equalsIgnoreCase("s"));

			System.out.println("Revise os dados antes de confirmar:");
			System.out.println("Funcionário que está registrando a compra:" + Repositorio.funcionarioLogado.getNome());
			System.out.println("Cliente que está comprando: " + cliente.getNome());
			System.out.println("Quantidade de cursos selecionados: " + cursos.size());

			System.out.println("Confirma a compra ?(S/N)");
			resposta = entrada.next();
			if (resposta.equalsIgnoreCase("s")) {

				Compra compra = new Compra(cliente.getCpf(), Repositorio.funcionarioLogado.getCpf(), cursos);
				Repositorio.compras.put(compra.getDataCompra().format(DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm")),
						compra);
			} else {
				throw new CompraNaoEfetuadaException();
			}
		} catch (ClienteNaoLocalizadoException e) {
			System.out.println("A compra não foi efetuada, motivo: " + e.getMessage());
		} catch (CompraNaoEfetuadaException e) {
			System.out.println("A compra não foi efetuada, motivo: " + e.getMessage());
		}

	}

	private void listarHistoricoCompras() {

		for (Entry<String, Compra> compra : Repositorio.compras.entrySet()) {
			System.out.println("CHAVE:" + compra.getKey() + TABULACAO + "Quem vendeu:"
					+ compra.getValue().getClienteChave() + " - Quem comprou:" + compra.getValue().getFuncionarioChave()
					+ "Quantidade de cursos:" + compra.getValue().getCursos().size()
					+ (compra.getValue().getDataCancelado() != null
							? " - Cancelado em:"
									+ compra.getValue().getDataCompra().format(DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm"))
							: ""));
		}

	}

}
