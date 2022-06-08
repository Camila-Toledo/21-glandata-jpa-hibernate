package br.com.glandata.jpa.main;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.CategoriaDao;
import br.com.glandata.jpa.model.Categoria;
import br.com.glandata.jpa.util.JPAUtil;

public class TestaMerge {

	public static void main(String[] args) {

		Categoria categoria = new Categoria("Vestuario");

		EntityManager em = JPAUtil.getEntityManager();

		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(categoria);

		categoria.setNome("Eletronicos");
		em.flush(); // Simula o commit // Envia informações para o BD
		em.clear(); // Simula o close // Limpa ou fecha o gerenciamento do objeto
		categoria = em.merge(categoria); // Recarrega o objeto atualizado

		categoria.setNome("Brinquedos");

		em.getTransaction().commit();

		em.close();

	}

}
