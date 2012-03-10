package com.autentia.demo.ejb;

/**
 * Esta excepción se lanza cuando se intenta añadir un nuevo mensaje de saludo y el saludador considera que no es apropiado,
 * por ejemplo porque el mensaje no sea suficientemente educado. Es el saludador el que decide si el mensaje es valido o no,
 * normalmente preguntando a algun moderador.
 */
public class InvalidGreetingMessageException extends Exception {

	private static final long serialVersionUID = -8919726835192958385L;

	public InvalidGreetingMessageException() {
		// Default constructor.
	}

	public InvalidGreetingMessageException(String msg) {
		super(msg);
	}

	public InvalidGreetingMessageException(Exception e) {
		super(e);
	}
}
