package dominio;

import java.math.BigDecimal;
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

}
