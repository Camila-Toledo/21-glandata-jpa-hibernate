package br.com.glandata.jpa.main;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.CategoriaDao;
import br.com.glandata.jpa.model.Categoria;
import br.com.glandata.jpa.util.JPAUtil;

public class DeletaCategoria {

	public static void main(String[] args) {

		Categoria categoria = new Categoria(3L);

		EntityManager em = JPAUtil.getEntityManager();

		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.deletar(categoria);

		em.getTransaction().commit();

		em.close();

	}

}
