package br.com.glandata.jpa.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.glandata.jpa.dao.ProdutoDao;
import br.com.glandata.jpa.model.Categoria;
import br.com.glandata.jpa.model.Produto;
import br.com.glandata.jpa.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {

		// Produto produto = new Produto();
		// produto.setNome("Moto G34");
		// produto.setDescricao("Smartphone Motorola 5G");
		// produto.setPreco(new BigDecimal("1300.00"));
		// produto.setCategoria(Categoria.ELETRONICOS);

		// EntityManagerFactory factory =
		// Persistence.createEntityManagerFactory("glandata");
		// EntityManager em = factory.createEntityManager();
		// em.getTransaction().begin();
		// em.persist(produto);
		// em.getTransaction().commit();
		// em.close();

		Produto produto = new Produto("IPHONE 13 Ultra", "Apple Iphone", new BigDecimal("10000.00"), Categoria.ELETRONICOS); //Cria o objeto

		EntityManager em = JPAUtil.getEntityManager(); // Invoca o gerente de conexão

		ProdutoDao produtoDao = new ProdutoDao(em);// Instancia a classe DAO

		try {
			em.getTransaction().begin();// Inicia a transação
			produtoDao.cadastrar(produto);// Salva o produto em persist(produto)
			em.getTransaction().commit();// Commita os valores
		} catch (Exception e) {
			System.out.println("Erro ao inserir: " + e.getMessage());
		} finally {
			em.close();// Fecha a conexão

		}

	}

}
