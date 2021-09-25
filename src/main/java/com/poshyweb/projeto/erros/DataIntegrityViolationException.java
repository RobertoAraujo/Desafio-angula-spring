package com.poshyweb.projeto.erros;

public class DataIntegrityViolationException  extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationException() {
		super();
		
	}

	public DataIntegrityViolationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DataIntegrityViolationException(String message) {
		super(message);
		
	}

	public DataIntegrityViolationException(Throwable cause) {
		super(cause);
		
	}
	
	

	
	
	
	

}
