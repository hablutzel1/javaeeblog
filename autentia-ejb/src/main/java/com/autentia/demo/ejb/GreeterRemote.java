package com.autentia.demo.ejb;

import javax.ejb.Remote;

/**
 * Interfaz remota de un saludador. Para poder invocar el EJB desde fuera del servidor de aplicaciones donde reside.
 */
@Remote
public interface GreeterRemote extends Greeter {

}
