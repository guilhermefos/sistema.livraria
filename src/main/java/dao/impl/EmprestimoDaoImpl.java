package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.EmprestimoDao;
import dominio.Emprestimo;

public class EmprestimoDaoImpl implements EmprestimoDao {

	private EntityManager em;

	public EmprestimoDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Emprestimo x) {
		if (x.getCodEmprestimo() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Emprestimo x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Emprestimo buscar(int cod) {
		return em.find(Emprestimo.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emprestimo> buscarTodos() {
		String jpql = "SELECT x FROM Emprestimo x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
