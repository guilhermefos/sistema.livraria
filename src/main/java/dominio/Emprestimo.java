package dominio;

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

}
