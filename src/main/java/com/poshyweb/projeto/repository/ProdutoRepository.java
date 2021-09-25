package com.poshyweb.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poshyweb.projeto.dominio.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long>{
	
	@Query("SELECT obj FROM Produto obj WHERE obj.categoria.id = :id_cat ORDER BY id")
	List<Produto> findByCategoria(@Param(value = "id_cat")Long id_cat);

}
