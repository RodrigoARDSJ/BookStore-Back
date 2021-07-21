package com.rodrigo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rodrigo.bookstore.domain.Categoria;
import com.rodrigo.bookstore.exception.ObjNotFoundException;
import com.rodrigo.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria FindById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException(
				"Categoria não encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, Categoria objDTO) {
		Categoria obj = FindById(id);
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		FindById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.rodrigo.bookstore.exception.DataIntegrityVioletionException(
					"Categoria não pode ser excluido. Existe livros associado");
			
		}

	}

}
