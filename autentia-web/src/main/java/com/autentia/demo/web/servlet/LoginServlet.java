package com.autentia.demo.web.servlet;

import com.autentia.demo.ejb.UsuariosManager;
import com.autentia.demo.ejb.domain.Usuario;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 3/03/12
 * Time: 11:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet {


    public static final String BASE_CONTEXT = "/autentia-web/";

    @EJB
    private UsuariosManager usuariosManager;

    public LoginServlet() {

//        final Context context;
//        try {
//            context = new InitialContext();
//            usuariosManager = (UsuariosManager) context.lookup("UsuariosManagerImpl/local");
//
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        

        //  query entity EJB for user
        Usuario usuario1 = usuariosManager.buscarUsuario(usuario);

        if (usuario1 != null) { //  if user exists put the username in session

            if (!usuario1.getPassword().equals(password)) { // pasowrd incorrect
                request.setAttribute("error", "Contraseña incorrecta");
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            } else {

                HttpSession session = request.getSession(true);
                session.setAttribute("username", usuario);

                // redirect to index
                response.sendRedirect(BASE_CONTEXT);
            }
            
        } else {
            //  error and message the user doesn't exist
            request.setAttribute("error", "El usuario no existe");
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);



        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO if user already logged redirect to home page with message, you are already logged

        HttpSession session = request.getSession(false);
        if (session != null&& session.getAttribute("username") != null) {
            response.sendRedirect(BASE_CONTEXT);
        }
        
        //  display login view
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
