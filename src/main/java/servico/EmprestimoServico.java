package servico;

import java.util.List;

import dao.DaoFactory;
import dao.EmprestimoDao;
import dao.Transaction;
import dao.impl.EM;
import dominio.Emprestimo;

public class EmprestimoServico {
	
	private EmprestimoDao dao;
	
	public EmprestimoServico() {
		dao = DaoFactory.criarEmprestimoDao();
	}
	
	/**
	 * 
	 * Insert or Update Emprestimo object
	 * 
	 * @param x Emprestimo object from update
	 * 
	 * @return void
	 * 
	 */
	public void inserirAtualizar(Emprestimo x) 
	{
		try
		{
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch(RuntimeException e)
		{
			Transaction.rollback();
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void excluir(Emprestimo x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Emprestimo buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Emprestimo> buscarTodos() {
		return dao.buscarTodos();
	}

}
