package com.autentia.demo.web.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 4/03/12
 * Time: 04:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseServlet extends HttpServlet {

    /**
     * Returns true if theres a logged in user
     * @param request
     * @return
     */
    public static boolean isUserLoggedIn(HttpServletRequest request) {
        boolean isValidUserSession = false;
        HttpSession session = request.getSession(false);
        if (session != null) {
            Object username = session.getAttribute("username");
            if (username != null) {
                isValidUserSession = true;
            }
        }
        return isValidUserSession;
    }
}
