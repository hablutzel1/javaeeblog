package com.autentia.demo.ejb.impl;

import com.autentia.demo.ejb.PostsManager;
import com.autentia.demo.ejb.domain.Post;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 4/03/12
 * Time: 12:18 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class PostsManagerImpl implements PostsManager {

    @PersistenceContext
    private EntityManager em;


    public Post savePost(Post post) {
        post.setFechaPublicado(new Timestamp(new Date().getTime()));
        em.persist(post); // no need to flush and the id is there :O
        return  post;
    }

    public List<Post> getAllPosts() {


        return em.createQuery("from Post order by fechaPublicado desc ").getResultList();
    }
}
