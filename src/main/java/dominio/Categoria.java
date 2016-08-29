package dominio;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	// Internal Variables
	private Integer codCategoria;
	private String nome;
	
	// Relationship Variables
	private List<Livro>livros;
	
	public Categoria()
	{
		this.livros = new ArrayList<>();
	}

	public Categoria(Integer codCategoria, String nome) {
		super();
		this.codCategoria = codCategoria;
		this.nome = nome;
		this.livros = new ArrayList<>();
	}

}
