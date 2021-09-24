package com.poshyweb.projeto.serve;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.poshyweb.projeto.dominio.Categoria;
import com.poshyweb.projeto.repository.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public  Categoria findById(Long id) throws ObjectNotFoundException {
		Optional<Categoria> objCategoria = categoriaRepository.findById(id);
		return objCategoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado !! id, " + id + " tipo " + Categoria.class.getName()));
	}
	@GetMapping
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}

}
