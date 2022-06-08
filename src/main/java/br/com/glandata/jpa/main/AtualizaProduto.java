package br.com.glandata.jpa.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.CategoriaDao;
import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Categoria;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class AtualizaProduto {

	public static void main(String[] args) {

		Produto produto = new Produto(3L);
		produto.setNome("TV 50 Polegadas");
		produto.setDescricao("Aparelho televisor LCD 50");
		produto.setPreco(new BigDecimal("2000"));
		produto.setCategoria(new Categoria("Televisores"));

		EntityManager em = JPAUtil.getEntityManager();

		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(produto.getCategoria());
		produtoDao.atualizar(produto);

		em.getTransaction().commit();
		em.close();

	}

}
