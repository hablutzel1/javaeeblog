package com.autentia.demo.ejb.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 4/03/12
 * Time: 12:02 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "entrada")
public class Post {


    private int id;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    private String titulo;
    
    private String contenido;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Timestamp fechaPublicado;

    @Column(name = "fecha_publicado")
    public Timestamp getFechaPublicado() {
        return fechaPublicado;
    }

    public void setFechaPublicado(Timestamp fechaPublicado) {
        this.fechaPublicado = fechaPublicado;
    }
}
