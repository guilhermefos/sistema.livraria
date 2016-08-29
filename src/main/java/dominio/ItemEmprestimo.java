package dominio;

public class ItemEmprestimo {
	
	// Internal Variables
	private Integer codItemEmprestimo;
	private Integer quantidade;
	
	// Relationship Variables
	private Livro livro;
	private Emprestimo emprestimo;
	
	public ItemEmprestimo(){}

	public ItemEmprestimo(Integer codItemEmprestimo, Integer quantidade, Livro livro, Emprestimo emprestimo) {
		super();
		this.codItemEmprestimo = codItemEmprestimo;
		this.quantidade = quantidade;
		this.livro = livro;
		this.emprestimo = emprestimo;
	}

}
