package com.autentia.demo.ejb;

import javax.ejb.Local;

/**
 * Interfaz de un saludador Es local, así que sólo se puede usar desde el servidor de aplicaciones donde reside el EJB.
 */
@Local
public interface Greeter {

	public String sayHi();

	public void addGreeting(String message) throws InvalidGreetingMessageException;
}
