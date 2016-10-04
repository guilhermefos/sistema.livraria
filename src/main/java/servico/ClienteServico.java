package servico;

import java.util.List;
import dao.ClienteDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Cliente;

public class ClienteServico {
	
	private ClienteDao dao;
	
	public ClienteServico() {
		dao = DaoFactory.criarClienteDao();
	}
	
	
	/**
	 * 
	 * Insert Client object
	 * 
	 * @param x Cliente object from update
	 * 
	 * @return void
	 * 
	 */
	public void inserir(Cliente x) throws ServicoException {
		try {
			Cliente aux = dao.buscaClientePorCpf(x.getCpf());
			if (aux != null) {
				throw new ServicoException("Já existe um cliente com esse CPF! Inserção cancelada.", 1);
			}
			
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	/**
	 * 
	 * Update Cliente object
	 * 
	 * @param x Cliente object from update
	 * 
	 * @return void
	 * 
	 */
	public void atualizar(Cliente x) throws ServicoException {
		try {
			Cliente aux = dao.buscaClientePorCpf(x.getCpf());
			if (aux != null && aux.getCodCliente() != x.getCodCliente()) {
				throw new ServicoException("Já existe um cliente com esse CPF! Atualização cancelada.", 1);
			}
			
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * Delete Cliente object
	 * 
	 * @param x Cliente object from delete
	 * 
	 * @return void
	 * 
	 */
	public void excluir(Cliente x) throws ServicoException {
		try {
			x = dao.buscar(x.getCodCliente());
			if (!x.getEmprestimos().isEmpty()) {
				throw new ServicoException("Exclusão não permitida! Cliente possui emprestimos!", 2);
			}
			
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * Select a Cliente object
	 * 
	 * @param cod int to find
	 * 
	 */
	public Cliente buscar(int cod) 
	{
		return dao.buscar(cod);
	}
	
	/**
	 * 
	 * Select all Cliente objects
	 * 
	 * @return List of Cliente objects
	 * 
	 */
	public List<Cliente> buscarTodos() 
	{
		return dao.buscarTodos();
	}

}
