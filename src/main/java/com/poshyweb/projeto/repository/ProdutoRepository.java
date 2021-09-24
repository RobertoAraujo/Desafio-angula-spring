package com.poshyweb.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poshyweb.projeto.dominio.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long>{

}
