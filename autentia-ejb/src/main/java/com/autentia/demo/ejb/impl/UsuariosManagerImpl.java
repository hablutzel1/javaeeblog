package com.autentia.demo.ejb.impl;

import com.autentia.demo.ejb.UsuariosManager;
import com.autentia.demo.ejb.domain.Usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 4/03/12
 * Time: 12:18 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class UsuariosManagerImpl implements UsuariosManager {

    @PersistenceContext
    private EntityManager em;

    public Usuario buscarUsuario(String username) {

        return em.find(Usuario.class, username);
    }

}
