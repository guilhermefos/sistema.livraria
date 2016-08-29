package dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Livro {
	
	// Internal Variables
	private Integer codLivro;
	private String titulo, isbn;
	private Integer paginas;
	private BigDecimal valorDiario;
	
	// Relationship Variables
	private Editora editora;
	private Categoria categoria;
	private List<ItemEmprestimo> itens;
	
	private Livro()
	{
		this.itens = new ArrayList<>();
	}

	public Livro(Integer codLivro, String titulo, String isbn, Integer paginas, BigDecimal valorDiario, Editora editora,
			Categoria categoria) {
		super();
		this.codLivro = codLivro;
		this.titulo = titulo;
		this.isbn = isbn;
		this.paginas = paginas;
		this.valorDiario = valorDiario;
		this.editora = editora;
		this.categoria = categoria;
		this.itens = new ArrayList<>();
	}
	
	

}
