package com.poshyweb.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poshyweb.projeto.dominio.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
