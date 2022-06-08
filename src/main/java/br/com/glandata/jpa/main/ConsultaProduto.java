package br.com.glandata.jpa.main;

import javax.persistence.EntityManager;

import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class ConsultaProduto {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);

		Produto produto = produtoDao.buscarPorId(1L);

		System.out.println("Dados do produto:" + produto);

	}

}
