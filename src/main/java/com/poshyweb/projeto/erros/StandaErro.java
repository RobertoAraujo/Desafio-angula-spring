package com.poshyweb.projeto.erros;

import java.util.Objects;

public class StandaErro {
	private Long timestamp;
	private Integer sattus;
	private String erro;
	
	public StandaErro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandaErro(Long timestamp, Integer sattus, String erro) {
		super();
		this.timestamp = timestamp;
		this.sattus = sattus;
		this.erro = erro;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getSattus() {
		return sattus;
	}

	public void setSattus(Integer sattus) {
		this.sattus = sattus;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(erro, sattus, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StandaErro other = (StandaErro) obj;
		return Objects.equals(erro, other.erro) && Objects.equals(sattus, other.sattus)
				&& Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "StandaErro [timestamp=" + timestamp + ", sattus=" + sattus + ", erro=" + erro + "]";
	}
	
	
}
