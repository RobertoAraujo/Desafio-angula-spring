package com.poshyweb.projeto.erros;

import java.io.Serializable;

public class ErroDeCamposMensagems implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nomeDoCampo;
	private String mensagemDeErro;
	
	public ErroDeCamposMensagems() {
		super();
	}

	public ErroDeCamposMensagems(String nomeDoCampo, String mensagemDeErro) {
		super();
		this.nomeDoCampo = nomeDoCampo;
		this.mensagemDeErro = mensagemDeErro;
	}

	public String getNomeDoCampo() {
		return nomeDoCampo;
	}

	public void setNomeDoCampo(String nomeDoCampo) {
		this.nomeDoCampo = nomeDoCampo;
	}

	public String getMensagemDeErro() {
		return mensagemDeErro;
	}

	public void setMensagemDeErro(String mensagemDeErro) {
		this.mensagemDeErro = mensagemDeErro;
	}

	

}
