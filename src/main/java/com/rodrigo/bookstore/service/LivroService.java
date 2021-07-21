package com.rodrigo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.bookstore.domain.Categoria;
import com.rodrigo.bookstore.domain.Livro;
import com.rodrigo.bookstore.exception.ObjNotFoundException;
import com.rodrigo.bookstore.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro FindById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj
				.orElseThrow(() -> new ObjNotFoundException("Livro não encontrado! Id:" + id + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.FindById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.FindById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = FindById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNomeAutor(obj.getNomeAutor());
		newObj.setTextoLivro(obj.getTextoLivro());

	}

	public void delete(Integer id) {
		Livro obj = FindById(id);
		repository.delete(obj);
	}

}
