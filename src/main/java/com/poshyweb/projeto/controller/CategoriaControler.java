package com.poshyweb.projeto.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.poshyweb.projeto.dominio.Categoria;
import com.poshyweb.projeto.dto.CategoriaDTO;
import com.poshyweb.projeto.serve.CategoriaService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaControler {
	
	@Autowired
	private CategoriaService categoriaService; 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) throws ObjectNotFoundException{
		Categoria objCategoria = categoriaService.findByIderro(id);
		return ResponseEntity.ok().body(objCategoria);
		
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = categoriaService.findAll();
		List<CategoriaDTO> listDTO = list.stream().map( objCategoria -> new CategoriaDTO(objCategoria)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	// salva no banco
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria objCategoria){
		objCategoria = categoriaService.create(objCategoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objCategoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @RequestBody CategoriaDTO objDTO) throws ObjectNotFoundException{
		Categoria objnovo = categoriaService.update(id, objDTO);
		return ResponseEntity.ok().body(new CategoriaDTO(objnovo));
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws ObjectNotFoundException {
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
