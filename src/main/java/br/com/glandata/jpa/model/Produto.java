package br.com.glandata.jpa.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity // Indica ao JPA que existe uma tabela no banco de dados que está mapeada a essa  classe
@Table(name = "produtos", // nomeia a tabela no banco de dados
		indexes = { @Index(name = "id_produto", columnList = "id") })
// uniqueConstraints = { @UniqueConstraint(name = "nome_unique", columnNames =
// "nome") }

public class Produto {
	
	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	@Getter
	@Setter
	@Id // Informa que este atributo é a primary key da tabela no mundo relacional
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que o banco de dados tomará conta de gerar o Id
	private Long id;

	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	private String descricao;

	@Getter
	@Setter
	private BigDecimal preco;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	@Getter
	@Setter
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro = LocalDate.now();

}
