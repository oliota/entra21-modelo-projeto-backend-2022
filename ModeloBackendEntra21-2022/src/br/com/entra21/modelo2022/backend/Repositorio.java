package br.com.entra21.modelo2022.backend;

import java.util.HashMap;

import br.com.entra21.modelo2022.backend.modelos.Cliente;
import br.com.entra21.modelo2022.backend.modelos.Curso;

public class Repositorio {

	public static HashMap<String,Curso> cursos=new HashMap<>();
	public static HashMap<String,Cliente> clientes=new HashMap<>();
	
	
	public static void gerarMassaTeste() {

		cursos.put("Metodologia �gil",new Curso("Metodologia �gil",700));
		cursos.put("Git",new Curso("Git",300));
		cursos.put("L�gica de programa��o",new Curso("L�gica de programa��o",800));
		
		

		clientes.put("001",new Cliente("Fulano",(byte)32,"001"));
		clientes.put("002",new Cliente("Fulano",(byte)32,"002"));
		clientes.put("003",new Cliente("Fulano",(byte)32,"003")); 
	}

}