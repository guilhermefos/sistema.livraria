package dominio;

import java.math.BigDecimal;
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

}
