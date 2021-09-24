package com.poshyweb.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poshyweb.projeto.dominio.Categoria;
import com.poshyweb.projeto.serve.CategoriaService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaControler {
	
	@Autowired
	private CategoriaService categoriaService; 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) throws ObjectNotFoundException{
		Categoria objCategoria = categoriaService.findById(id);
		return ResponseEntity.ok().body(objCategoria);
		
	}

}
