package br.com.glandata.jpa.dao;

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

}
