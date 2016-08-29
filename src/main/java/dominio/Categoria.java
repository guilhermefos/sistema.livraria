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

	/**
	 * @return the codCategoria
	 */
	public Integer getCodCategoria() {
		return codCategoria;
	}

	/**
	 * @param codCategoria the codCategoria to set
	 */
	public void setCodCategoria(Integer codCategoria) {
		this.codCategoria = codCategoria;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the livros
	 */
	public List<Livro> getLivros() {
		return livros;
	}

	/**
	 * @param livros the livros to set
	 */
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Categoria [codCategoria=" + codCategoria + ", nome=" + nome + "]";
	}
	
	

}
