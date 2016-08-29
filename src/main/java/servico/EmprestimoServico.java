package servico;

import java.util.List;

import dao.DaoFactory;
import dao.EmprestimoDao;
import dao.impl.EM;
import dominio.Emprestimo;

public class EmprestimoServico {
	
	private EmprestimoDao dao;
	
	public EmprestimoServico() {
		dao = DaoFactory.criarEmprestimoDao();
	}
	
	public void inserirAtualizar(Emprestimo x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
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
