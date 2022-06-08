package br.com.glandata.jpa.dao;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.model.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		em.persist(categoria);
	}

	public void deletar(Categoria categoria) {
		categoria = em.merge(categoria);
		em.remove(categoria);
	}

}
