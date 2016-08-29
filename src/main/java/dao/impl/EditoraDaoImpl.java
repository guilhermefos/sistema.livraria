package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.EditoraDao;
import dominio.Editora;

public class EditoraDaoImpl implements EditoraDao {

	private EntityManager em;

	public EditoraDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Editora x) {
		if (x.getCodEditora() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Editora x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Editora buscar(int cod) {
		return em.find(Editora.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Editora> buscarTodos() {
		String jpql = "SELECT x FROM Editora x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
