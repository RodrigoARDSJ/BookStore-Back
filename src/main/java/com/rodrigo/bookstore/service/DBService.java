package com.rodrigo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.bookstore.domain.Categoria;
import com.rodrigo.bookstore.domain.Livro;
import com.rodrigo.bookstore.repositories.CategoriaRepository;
import com.rodrigo.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciarBaseDeDados() {
		Categoria categoria1 = new Categoria(null, "Informatica", "Livros de Ti");
		Categoria categoria2 = new Categoria(null, "Romance", "Livros de romance");
		Categoria categoria3 = new Categoria(null, "Suspense", "Livros de Suspense");

		Livro livro = new Livro(null, "Clean Code", "Robert", "Lorem Ipsum", categoria1);
		Livro livro2 = new Livro(null, "Orgulho e preconceito", "Jane Austen", "Lorem Ipsum", categoria2);
		Livro livro3 = new Livro(null, "Anne e a casa dos sonhos", "Lucy Mound", "Lorem Ipsum", categoria2);
		Livro livro4 = new Livro(null, "Sherlock Holmes", "Robert", "sla", categoria3);

		categoria1.getLivros().addAll(Arrays.asList(livro));
		categoria2.getLivros().addAll(Arrays.asList(livro2));
		categoria3.getLivros().addAll(Arrays.asList(livro3));

		this.categoriaRepository.saveAll(Arrays.asList(categoria1));
		this.categoriaRepository.saveAll(Arrays.asList(categoria2));
		this.categoriaRepository.saveAll(Arrays.asList(categoria3));

		this.livroRepository.saveAll(Arrays.asList(livro));
		this.livroRepository.saveAll(Arrays.asList(livro2));
		this.livroRepository.saveAll(Arrays.asList(livro3));
		this.livroRepository.saveAll(Arrays.asList(livro4));
	}

}
