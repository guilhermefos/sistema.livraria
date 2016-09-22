package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ItemEmprestimoDao;
import dao.Transaction;
import dao.impl.EM;
import dominio.ItemEmprestimo;

public class ItemEmprestimoServico {
	
	private ItemEmprestimoDao dao;
	
	public ItemEmprestimoServico() {
		dao = DaoFactory.criarItemEmprestimoDao();
	}
	
	/**
	 * 
	 * Insert or Update ItemEmprestimo object
	 * 
	 * @param x ItemEmprestimo object from update
	 * 
	 * @return void
	 * 
	 */
	public void inserirAtualizar(ItemEmprestimo x) 
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
	
	public void excluir(ItemEmprestimo x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public ItemEmprestimo buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<ItemEmprestimo> buscarTodos() {
		return dao.buscarTodos();
	}

}
