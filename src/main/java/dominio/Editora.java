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

	/**
	 * @return the codEditora
	 */
	public Integer getCodEditora() {
		return codEditora;
	}

	/**
	 * @param codEditora the codEditora to set
	 */
	public void setCodEditora(Integer codEditora) {
		this.codEditora = codEditora;
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
		return "Editora [codEditora=" + codEditora + ", nome=" + nome + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEditora == null) ? 0 : codEditora.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Editora)) {
			return false;
		}
		Editora other = (Editora) obj;
		if (codEditora == null) {
			if (other.codEditora != null) {
				return false;
			}
		} else if (!codEditora.equals(other.codEditora)) {
			return false;
		}
		return true;
	}
	
	

}
