package br.com.glandata.jpa.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class ConsultaProduto {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);

		Produto produto = produtoDao.buscarPorId(50L);

		if (produto == null) {
			System.out.println("\n\nProduto não encontrado");
		} else {
			System.out.println("\n\nDados do produto:" + produto.getNome());
		}

		try {
			String nomeProduto = "IPHONE 13 Ultr";
			BigDecimal precoProduto = produtoDao.buscarPrecoProduto(nomeProduto);
			System.out.println("\n\nO valor do " + nomeProduto + " é " + precoProduto);
		} catch (Exception e) {
			System.out.println("\n\nProduto não encontrado");
		}

	}

}
