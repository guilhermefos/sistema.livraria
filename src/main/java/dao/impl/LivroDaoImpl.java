package dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.LivroDao;
import dominio.Livro;

public class LivroDaoImpl implements LivroDao{

	private EntityManager em;

	public LivroDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Livro x) {
		if (x.getCodLivro() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Livro x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Livro buscar(int cod) {
		return em.find(Livro.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Livro> buscarTodos() {
		String jpql = "SELECT x FROM Livro x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Livro buscaTituloExato(String titulo) {
		String jpql = "SELECT x FROM Livro x WHERE x.titulo = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", titulo);
		List<Livro> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Livro buscaLivroPorIsbn(String isbn) {
		String jpql = "SELECT x FROM Livro x WHERE x.isbn = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", isbn);
		List<Livro> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Livro> buscarPorTitulo(String trecho) {
		String jpql = "SELECT x FROM Livro x WHERE x.titulo LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+trecho+"%");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Livro> buscarPorTituloValorMinimoValorMaximo(String trecho, BigDecimal vlrMin, BigDecimal vlrMax) {
		String jpql = "SELECT x FROM Livro x WHERE x.titulo LIKE :p1 and x.valorDiario BETWEEN :p2 AND :p3 ORDER BY x.titulo";	//acrescentar ORDER BY x.titulo
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+trecho+"%");
		query.setParameter("p2", vlrMin);
		query.setParameter("p3", vlrMax);
		return query.getResultList();
	}

}
