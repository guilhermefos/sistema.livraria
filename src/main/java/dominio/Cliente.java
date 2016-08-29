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

	/**
	 * @return the codCliente
	 */
	public Integer getCodCliente() {
		return codCliente;
	}

	/**
	 * @param codCliente the codCliente to set
	 */
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
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
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}

	/**
	 * @param fone the fone to set
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the nascimento
	 */
	public Date getNascimento() {
		return nascimento;
	}

	/**
	 * @param nascimento the nascimento to set
	 */
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	/**
	 * @return the rendaMensal
	 */
	public BigDecimal getRendaMensal() {
		return rendaMensal;
	}

	/**
	 * @param rendaMensal the rendaMensal to set
	 */
	public void setRendaMensal(BigDecimal rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	/**
	 * @return the emprestimos
	 */
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	/**
	 * @param emprestimos the emprestimos to set
	 */
	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", nome=" + nome + ", cpf=" + cpf + ", fone=" + fone + ", email="
				+ email + ", nascimento=" + nascimento + ", rendaMensal=" + rendaMensal + "]";
	}
	
	
}
