package com.autentia.demo.ejb;

import com.autentia.demo.ejb.domain.Usuario;

import javax.ejb.Local;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 4/03/12
 * Time: 12:19 AM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface UsuariosManager {
    Usuario buscarUsuario(String username);
}
