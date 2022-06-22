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

		List<Produto> listaProdutoPorNome = produtoDao.buscarPorNome("IPHONE 13 Ultra");
		System.out.println("\n\nLISTA TODOS OS PRODUTOS POR NOME INFORMADO");
		System.out.println("ID \t NOME \t\t\t DESCRIÇÃO \t\t PREÇO \t\t\t CATEGORIA");
		listaProdutoPorNome.forEach(p -> {
			System.out.println(p.getId() + "\t " + p.getNome() + "\t " + p.getDescricao() + "\t\t " + p.getPreco()
					+ "\t\t " + p.getCategoria().getNome());
		});

		System.out.println("\n\nLista de produtos por nome da categoria");
		List<Produto> listaProdutosPorCategoria = produtoDao.listaProdutosPorCategoria("Celulares");
		listaProdutosPorCategoria.forEach(p -> {
			System.out.println(p.getNome());
		});
		
		
	}

}
