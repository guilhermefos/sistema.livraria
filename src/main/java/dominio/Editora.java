package dominio;

import java.util.ArrayList;
import java.util.List;

public class Editora {
	
	// Internal Variables
	private Integer codEditora;
	private String nome;
	
	// Relationship Variables
	private List<Livro>livros;
	
	public Editora()
	{
		this.livros = new ArrayList<>();
	}

	public Editora(Integer codEditora, String nome) {
		super();
		this.codEditora = codEditora;
		this.nome = nome;
		this.livros = new ArrayList<>();
	}
	
	

}
