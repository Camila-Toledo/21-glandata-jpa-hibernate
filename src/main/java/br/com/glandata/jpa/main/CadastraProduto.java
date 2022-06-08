package br.com.glandata.jpa.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.CategoriaDao;
import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Categoria;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class CadastraProduto {

	public static void main(String[] args) {

		// Cria o objeto categoria
		Categoria categoria = new Categoria("Celulares");

		// Cria o objeto produto
		Produto produto = new Produto("IPHONE 13 Ultra", "Apple Iphone", new BigDecimal("10000.00"), categoria);

		// Invoca o gerente de conexão
		EntityManager em = JPAUtil.getEntityManager();

		// Instancia as classes DAO
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		// Inicia a transação
		em.getTransaction().begin();

		// Salva a categoria em persist(produto)
		categoriaDao.cadastrar(categoria);

		// Salva o produto em persist(produto)
		produtoDao.cadastrar(produto);

		// Commita os valores
		em.getTransaction().commit();

		// Fecha a conexão
		em.close();

	}

}
