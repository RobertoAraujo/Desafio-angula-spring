package com.poshyweb.projeto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poshyweb.projeto.dominio.Produto;
import com.poshyweb.projeto.dto.ProdutoDTO;
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
	// lista todos
	 
	 @GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll(@RequestParam(value ="categoria", defaultValue ="0") Long id_cat) throws ObjectNotFoundException  {
		 List<Produto> list = produtoService.findAll(id_cat);
		 //converte de lista de livro em lista de livros dto
		 List<ProdutoDTO> listDTO = list.stream().map(objProduto -> new ProdutoDTO(objProduto)).collect(Collectors.toList());
		//return ResponseEntity.ok().body(objProduto);
		 return ResponseEntity.ok().body(listDTO);
	}
	 
	
}
