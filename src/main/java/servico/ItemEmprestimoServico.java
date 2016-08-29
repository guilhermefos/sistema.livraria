package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ItemEmprestimoDao;
import dao.impl.EM;
import dominio.ItemEmprestimo;

public class ItemEmprestimoServico {
	
	private ItemEmprestimoDao dao;
	
	public ItemEmprestimoServico() {
		dao = DaoFactory.criarItemEmprestimoDao();
	}
	
	public void inserirAtualizar(ItemEmprestimo x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
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
