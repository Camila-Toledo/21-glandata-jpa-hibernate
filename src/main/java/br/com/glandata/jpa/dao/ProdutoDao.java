package br.com.glandata.jpa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.model.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		em.persist(produto);
	}

	public void atualizar(Produto produto) {
		em.merge(produto);
	}

	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}

	public void deletar(Produto produto) {
		em.remove(produto);
	}

	public List<Produto> listarProdutos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

	public List<Produto> buscarPorNome(String nomeProduto) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, Produto.class).setParameter("nome", nomeProduto).getResultList();
	}

	public List<Produto> listaProdutosPorCategoria(String nomeCategoria) {
		// String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
		String jpql = "SELECT p FROM Produto p INNER JOIN p.categoria c WHERE c.nome = :nome";
		return em.createQuery(jpql, Produto.class).setParameter("nome", nomeCategoria).getResultList();
	}

	public BigDecimal buscarPrecoProduto(String nomeProduto) {
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class).setParameter("nome", nomeProduto).setMaxResults(1)
				.getSingleResult();
	}

}
