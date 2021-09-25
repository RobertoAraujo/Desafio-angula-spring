package com.poshyweb.projeto.serve;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poshyweb.projeto.dominio.Produto;
import com.poshyweb.projeto.repository.ProdutoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired 
	private ProdutoRepository produtoRepository;

	public Produto findById(Long id) throws ObjectNotFoundException {
		Optional<Produto> objProduto = produtoRepository.findById(id);
		return objProduto.orElseThrow(()-> new ObjectNotFoundException("Produto não encontrado!  id:"+ id + "tipo: "+ Produto.class.getName()));
	}
}
