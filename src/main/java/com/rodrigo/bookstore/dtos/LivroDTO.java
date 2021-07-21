package com.rodrigo.bookstore.dtos;

import java.io.Serializable;

import com.rodrigo.bookstore.domain.Livro;

public class LivroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String titulo;
	private String nomeAutor;
	private String textoLivro;

	public LivroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.nomeAutor = obj.getNomeAutor();
		this.textoLivro = obj.getTextoLivro();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getTextoLivro() {
		return textoLivro;
	}

	public void setTextoLivro(String textoLivro) {
		this.textoLivro = textoLivro;
	}

}
