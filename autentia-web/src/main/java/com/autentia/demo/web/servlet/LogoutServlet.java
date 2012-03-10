package com.autentia.demo.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 4/03/12
 * Time: 03:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class LogoutServlet extends HttpServlet {


    public static  Logger logger = Logger.getLogger(LogoutServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO logout user
        HttpSession session = request.getSession(false);
        if (session != null) {
            Object username = session.getAttribute("username");
            if (username != null) {
                logger.log(Level.INFO, "Logging out " + username);
                session.setAttribute("success", "Se cerro sesión exitosamente" );
                session.removeAttribute("username");
            }
        }

        response.sendRedirect(LoginServlet.BASE_CONTEXT);

    }
}
