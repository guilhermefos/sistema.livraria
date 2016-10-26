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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Editora> buscaPorNome(String nome) {
		String jpql = "SELECT x FROM Editora x WHERE x.nome LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+nome+"%");
		return query.getResultList();
	}
	
	//Exceção 3.1.1 - incluir
	@SuppressWarnings("unchecked")
	@Override
	public Editora buscarNomeExato(String nome) {
		String jpql = "SELECT x FROM Editora x WHERE x.nome = :p1"; //p1 é o parametro 1.
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome);
		List<Editora> aux = query.getResultList();
		if(aux.size() > 0) {
			return aux.get(0);	//retorna primeiro elemento da lista.
		}else {
			return null;
		}
	}

	//Exceção 3.3.2 - Atualizar
	@SuppressWarnings("unchecked")
	@Override
	public Editora buscarNomeExatoDiferente(Integer codEditora, String nome) {
		String jpql = "SELECT x FROM Editora x WHERE x.codEditora <> :p0 AND x.nome = :p1";	//p1 e p0 são parametro.
		Query query = em.createQuery(jpql);
		query.setParameter("p0", codEditora);
		query.setParameter("p1", nome);
		List<Editora> aux = query.getResultList();
		if (aux.size() > 0)
			return aux.get(0);	//retorna primeiro elemento da lista.
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Editora> buscarTodosOrdenadosPorNome() {
		String jpql = "SELECT x FROM Editora x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
}
