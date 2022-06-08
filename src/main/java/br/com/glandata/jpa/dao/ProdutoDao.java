package br.com.glandata.jpa.dao;

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

}
