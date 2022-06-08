package br.com.glandata.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "categorias")
public class Categoria {

	public Categoria() {
	}

	public Categoria(Long id) {
		this.id = id;
	}

	public Categoria(String nome) {
		this.nome = nome;
	}

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	private String nome;

}
