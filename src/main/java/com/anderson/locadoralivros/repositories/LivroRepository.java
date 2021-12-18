package com.anderson.locadoralivros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anderson.locadoralivros.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
