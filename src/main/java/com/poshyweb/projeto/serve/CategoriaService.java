package com.poshyweb.projeto.serve;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poshyweb.projeto.dominio.Categoria;
import com.poshyweb.projeto.dto.CategoriaDTO;
import com.poshyweb.projeto.repository.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	// se exitir
	public  Categoria findByIderro(Long id) throws ObjectNotFoundException {
		Optional<Categoria> objCategoria = categoriaRepository.findById(id);
		return objCategoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado !! id, " + id + " tipo " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	// serviço de criar objeto
	public Categoria create(Categoria objCategoria) {
		objCategoria.setId(null);
		return categoriaRepository.save(objCategoria);
	}

	public Categoria update(Long id, CategoriaDTO objCategoriaDTO) throws ObjectNotFoundException {
		Categoria objCateg = findByIderro(id);
		objCateg.setNome(objCategoriaDTO.getNome());
		objCateg.setDescricao(objCategoriaDTO.getDescricao());
		return categoriaRepository.save(objCateg);
	}

	public void delete(Long id) throws ObjectNotFoundException {
		findByIderro(id);
		categoriaRepository.deleteById(id);
		
	}
	
}
