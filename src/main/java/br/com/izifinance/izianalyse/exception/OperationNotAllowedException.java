package br.com.izifinance.izianalyse.exception;

public class OperationNotAllowedException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public OperationNotAllowedException(String exception) {
		super(exception);
	}
	
	
}
