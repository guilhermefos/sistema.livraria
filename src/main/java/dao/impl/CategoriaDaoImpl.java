package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.CategoriaDao;
import dominio.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {

	private EntityManager em;

	public CategoriaDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Categoria x) {
		if (x.getCodCategoria() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Categoria x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Categoria buscar(int cod) {
		return em.find(Categoria.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> buscarTodos() {
		String jpql = "SELECT x FROM Categoria x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> buscaPorNome(String nome) {
		String jpql = "SELECT x FROM Categoria x WHERE x.nome LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+nome+"%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> buscarTodosOrdenadosPorNome() {
		String jpql = "SELECT x FROM Categoria x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	//Exceção 3.1.1 - incluir
	@SuppressWarnings("unchecked")
	@Override
	public Categoria buscarNomeExato(String nome) {
		String jpql = "SELECT x FROM Categoria x WHERE x.nome = :p1"; //p1 é o parametro 1.
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome);
		List<Categoria> aux = query.getResultList();
		if(aux.size() > 0) {
			return aux.get(0);	//retorna primeiro elemento da lista.
		}else {
			return null;
		}
	}

	//Exceção 3.3.2 - Atualizar
	@SuppressWarnings("unchecked")
	@Override
	public Categoria buscarNomeExatoDiferente(Integer codCategoria, String nome) {
		
		String jpql = "SELECT x FROM Categoria x WHERE x.codCategoria <> :p0 AND x.nome = :p1";	//p1 e p0 são parametro.
		Query query = em.createQuery(jpql);
		query.setParameter("p0", codCategoria);
		query.setParameter("p1", nome);
		List<Categoria> aux = query.getResultList();
		if (aux.size() > 0)
			return aux.get(0);	//retorna primeiro elemento da lista.
		else
			return null;
	}
}
