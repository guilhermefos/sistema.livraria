package dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
	
	// Internal Variables
	private Integer codCliente;
	private String nome, cpf, fone, email;
	private Date nascimento;
	private BigDecimal rendaMensal;
	
	// Relationship Variables
	private List<Emprestimo>emprestimos;
	
	Cliente()
	{
		this.emprestimos = new ArrayList<>();
	}

	public Cliente(Integer codCliente, String nome, String cpf, String fone, String email, Date nascimento,
			BigDecimal rendaMensal) {
		super();
		this.codCliente = codCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.fone = fone;
		this.email = email;
		this.nascimento = nascimento;
		this.rendaMensal = rendaMensal;
		this.emprestimos = new ArrayList<>();
	}
	
	

}
