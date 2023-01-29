package br.com.hospital.io.service.exceptions;

public class EmailJaExistenteException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	public EmailJaExistenteException(String message) {
		super(message);
	}
}
