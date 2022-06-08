package br.com.glandata.jpa.main;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class ListaProdutos {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);

		List<Produto> listaProdutos = produtoDao.listarProdutos();

		System.out.println("\n\nLISTA DE PRODUTOS");
		System.out.println("ID \t NOME \t\t\t DESCRIÇÃO \t\t\t\t PREÇO");

		listaProdutos.forEach(p -> {
			System.out.println(p.getId() + "\t " + p.getNome() + "\t " + p.getDescricao() + "\t\t " + p.getPreco());

		});

	}

}
