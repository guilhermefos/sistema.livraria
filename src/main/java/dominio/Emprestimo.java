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
	
	

}
