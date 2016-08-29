package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ItemEmprestimoDao;
import dominio.ItemEmprestimo;

public class ItemEmprestimoDaoImpl implements ItemEmprestimoDao {

	private EntityManager em;

	public ItemEmprestimoDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(ItemEmprestimo x) {
		if (x.getCodItemEmprestimo() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(ItemEmprestimo x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public ItemEmprestimo buscar(int cod) {
		return em.find(ItemEmprestimo.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemEmprestimo> buscarTodos() {
		String jpql = "SELECT x FROM ItemEmprestimo x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	

}
