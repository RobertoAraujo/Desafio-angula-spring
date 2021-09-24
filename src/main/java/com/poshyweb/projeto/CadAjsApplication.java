package com.poshyweb.projeto;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poshyweb.projeto.dominio.Categoria;
import com.poshyweb.projeto.dominio.Produto;
import com.poshyweb.projeto.repository.CategoriaRepository;
import com.poshyweb.projeto.repository.ProdutoRepository;

@SpringBootApplication
public class CadAjsApplication implements CommandLineRunner{
	
	@Autowired 
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CadAjsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// istanciando a categoria e inserido pelo construtor
		Categoria cat = new Categoria(null, "Informatica", "Aparelhos e Perifericos");
		// istanciando o Produto e inserido pelo construtor
		Produto prod = new Produto(null, "Mause", 20.22, cat);
		
		cat.getProduto().addAll(Arrays.asList(prod));
		
		// salva todas as categorias que forem lsiatda cat, cat1 ,cat2, cat3
		this.categoriaRepository.saveAll(Arrays.asList(cat));
		// salva todos os produto que forem lsiatdo prod , prod1 ,prod2 etc.......
		this.produtoRepository.saveAll(Arrays.asList(prod));
		
	}

}
