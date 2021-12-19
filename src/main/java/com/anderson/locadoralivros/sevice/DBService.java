package com.anderson.locadoralivros.sevice;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.locadoralivros.domain.Categoria;
import com.anderson.locadoralivros.domain.Livro;
import com.anderson.locadoralivros.repositories.CategoriaRepository;
import com.anderson.locadoralivros.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Tecnologia", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Suspense", "Dramaturgia");
		Categoria cat3 = new Categoria(null, "Português", "Academico");
		
		Livro l1 = new Livro(null, "Clean code", "Martin Roberto", "Loren ipsum", cat1);
		Livro l2 = new Livro(null, "Pânico", "Kyosaki", "Loren ipsum", cat2);
		Livro l3 = new Livro(null, "Fale, Leia e Escreva Melhor", "Frozen", "Loren ipsum", cat3);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l2));
		cat3.getLivros().addAll(Arrays.asList(l3));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3));
	}
}
