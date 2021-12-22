package com.anderson.locadoralivros.sevice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.locadoralivros.domain.Categoria;
import com.anderson.locadoralivros.repositories.CategoriaRepository;
import com.anderson.locadoralivros.sevice.exceptions.ObjectNotFounException;

@Service
public class CategoriaService {

	@Autowired // implementação da lógica de négocio
	private CategoriaRepository repository; // Injeta e traz as funcionalidades do objeto instanciado na classe repository, onde realiza as consultas e inserções de informações no banco de dados

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);// Optional é um recurso contido na llibrary do JPA onde ele traz uma lista de categorias pelo seu ID
		return obj.orElseThrow(() -> new ObjectNotFounException("Objeto não Encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
