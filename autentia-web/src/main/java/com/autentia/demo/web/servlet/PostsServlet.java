package com.autentia.demo.web.servlet;

import com.autentia.demo.ejb.PostsManager;
import com.autentia.demo.ejb.domain.Post;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 4/03/12
 * Time: 03:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class PostsServlet extends BaseServlet {

    private PostsManager postsManager;

    public PostsServlet() {

        final Context context;
        try {
            context = new InitialContext();
            postsManager = (PostsManager) context.lookup("PostsManagerImpl/local");

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isUserLoggedIn(request)) {         //  redirect to view

            //  persist post
            Post post = new Post();
            post.setTitulo(request.getParameter("titulo"));
            post.setContenido(request.getParameter("contenido"));
            postsManager.savePost(post);

            //  redirect to list of posts
            response.sendRedirect(LoginServlet.BASE_CONTEXT + "posts?list");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  check user is logged in
        if (isUserLoggedIn(request)) {         //  redirect to view

            if (request.getParameter("list") != null) {
                //  put all posts for view
                List<Post> allPosts = postsManager.getAllPosts();
                request.setAttribute("posts", allPosts);

                getServletContext().getRequestDispatcher("/posts/lista.jsp").forward(request, response);
            } else if (request.getParameter("crear") != null) {
                getServletContext().getRequestDispatcher("/posts/crear.jsp").forward(request, response);
            }

        } else {
            response.sendRedirect(LoginServlet.BASE_CONTEXT);

        }

    }

}
