package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emprestimo {
	
	// Internal Variables
	private Integer codEmprestimo;
	private Date dataEmprestimo;
	private Integer duracaoEmDias;
	
	// Relationship Variables
	private Cliente cliente;
	private List<ItemEmprestimo> itens;
	
	public Emprestimo()
	{
		this.itens = new ArrayList<>();
	}

	public Emprestimo(Integer codEmprestimo, Date dataEmprestimo, Integer duracaoEmDias, Cliente cliente) {
		super();
		this.codEmprestimo = codEmprestimo;
		this.dataEmprestimo = dataEmprestimo;
		this.duracaoEmDias = duracaoEmDias;
		this.cliente = cliente;
		this.itens = new ArrayList<>();
	}

	/**
	 * @return the codEmprestimo
	 */
	public Integer getCodEmprestimo() {
		return codEmprestimo;
	}

	/**
	 * @param codEmprestimo the codEmprestimo to set
	 */
	public void setCodEmprestimo(Integer codEmprestimo) {
		this.codEmprestimo = codEmprestimo;
	}

	/**
	 * @return the dataEmprestimo
	 */
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	/**
	 * @param dataEmprestimo the dataEmprestimo to set
	 */
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	/**
	 * @return the duracaoEmDias
	 */
	public Integer getDuracaoEmDias() {
		return duracaoEmDias;
	}

	/**
	 * @param duracaoEmDias the duracaoEmDias to set
	 */
	public void setDuracaoEmDias(Integer duracaoEmDias) {
		this.duracaoEmDias = duracaoEmDias;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the itens
	 */
	public List<ItemEmprestimo> getItens() {
		return itens;
	}

	/**
	 * @param itens the itens to set
	 */
	public void setItens(List<ItemEmprestimo> itens) {
		this.itens = itens;
	}

	
	

}
