package com.poshyweb.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poshyweb.projeto.dominio.Produto;
import com.poshyweb.projeto.serve.ProdutoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping (value = "/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	 @GetMapping (value = "/{id}")// busca geral
	public ResponseEntity<Produto> findById(@PathVariable Long id) throws ObjectNotFoundException {
		 Produto objProduto = produtoService.findById(id);
		return ResponseEntity.ok().body(objProduto);
	}
}
