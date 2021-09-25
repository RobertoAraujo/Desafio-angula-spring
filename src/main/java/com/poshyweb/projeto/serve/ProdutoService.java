package com.poshyweb.projeto.serve;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poshyweb.projeto.dominio.Categoria;
import com.poshyweb.projeto.dominio.Produto;
import com.poshyweb.projeto.repository.ProdutoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	// methodo de tratamento se nao tiver retorna mensagem
	public Produto findById(Long id) throws ObjectNotFoundException {
		Optional<Produto> objProduto = produtoRepository.findById(id);
		return objProduto.orElseThrow(()-> new ObjectNotFoundException("Produto não encontrado!  id:"+ id + "tipo: "+ Produto.class.getName()));
	}
	// methodo de lsita todos pro categoria
	public List<Produto> findAll(Long id_cat) throws ObjectNotFoundException {
		categoriaService.findByIderro(id_cat);
		return  produtoRepository.findByCategoria(id_cat);
	}
	// methodo de atualizar
	public Produto update(Long id, Produto objPoProd) throws ObjectNotFoundException {
		Produto novoProd = findById(id);
		updateData(novoProd, objPoProd);
		return produtoRepository.save(novoProd);
	}
	// tranferenia de informação
	private void updateData(Produto novoProd, Produto objPoProd) {
		novoProd.setNome(objPoProd.getNome());
		novoProd.setPreco(objPoProd.getPreco());
		
	}
	public Produto create(Long id_cat, Produto obProd) throws ObjectNotFoundException {
		obProd.setId(null);
		Categoria cat= categoriaService.findByIderro(id_cat);
		obProd.setCategoria(cat);
		return produtoRepository.save(obProd);
	}
}
