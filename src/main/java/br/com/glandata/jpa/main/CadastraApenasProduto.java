package br.com.glandata.jpa.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.CategoriaDao;
import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Categoria;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class CadastraApenasProduto {

	public static void main(String[] args) {

		// Cria o objeto produto
		Produto produto = new Produto("Samsung Galaxy S22", "Smartphone Samsung 5G", new BigDecimal("8000.00"),
				new Categoria(3L));
		Produto produto2 = new Produto("Iphone 13", "Smartphone Apple 5G", new BigDecimal("9500.00"),
				new Categoria(3L));

		// Invoca o gerente de conexão
		EntityManager em = JPAUtil.getEntityManager();

		// Instancia as classes DAO
		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();
		produtoDao.cadastrar(produto);
		produtoDao.cadastrar(produto2);
		em.getTransaction().commit();
		em.close();

	}

}
