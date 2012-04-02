package com.autentia.demo.web.servlet;

import com.autentia.demo.ejb.PostsManager;
import com.autentia.demo.ejb.domain.Post;
import org.apache.commons.lang.StringUtils;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 4/03/12
 * Time: 05:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class IndexServlet extends HttpServlet {

    @EJB
    private PostsManager postsManager;

    public IndexServlet() {

//        final Context context;
//        try {
//            context = new InitialContext();
//            postsManager = (PostsManager) context.lookup("PostsManagerImpl/local");
//
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // no op
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // this is serving / url path, do not interfere where other resources

        //  get all posts, display them in view
        List<Post> allPosts = postsManager.getAllPosts();

        if (allPosts.size() >0) {
            Post principalPost = allPosts.get(0);

            principalPost.setContenido(StringUtils.abbreviate(principalPost.getContenido(), 300));
            request.setAttribute("principalPost", principalPost);
            allPosts.remove(0);

            request.setAttribute("posts", allPosts);
        }

        

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
