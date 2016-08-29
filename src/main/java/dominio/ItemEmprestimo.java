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

	/**
	 * @return the codItemEmprestimo
	 */
	public Integer getCodItemEmprestimo() {
		return codItemEmprestimo;
	}

	/**
	 * @param codItemEmprestimo the codItemEmprestimo to set
	 */
	public void setCodItemEmprestimo(Integer codItemEmprestimo) {
		this.codItemEmprestimo = codItemEmprestimo;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the livro
	 */
	public Livro getLivro() {
		return livro;
	}

	/**
	 * @param livro the livro to set
	 */
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	/**
	 * @return the emprestimo
	 */
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	/**
	 * @param emprestimo the emprestimo to set
	 */
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	

}
