package com.poshyweb.projeto.erros;

import java.util.ArrayList;
import java.util.List;

public class ValidaErro extends StandaErro{
	
	private List<ErroDeCamposMensagems> erros = new ArrayList<>();

	public ValidaErro() {
		super();
		
	}

	public ValidaErro(Long timestamp, Integer sattus, String erro) {
		super(timestamp, sattus, erro);
		
	}

	public List<ErroDeCamposMensagems> getErros() {
		return erros;
	}

	public void addErros(String nomeDoCampo, String mensagemDeErro) {
		this.erros.add(new ErroDeCamposMensagems(nomeDoCampo, mensagemDeErro));
	}
	
	
	

}
