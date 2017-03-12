package su.ogorodov.controllers.servlets;

import su.ogorodov.common.exceptions.UserDaoException;
import su.ogorodov.services.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by smoldyrev on 23.02.17.
 */
public class RegistrationServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(RegistrationServlet.class);

    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.trace("on post");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        Integer accessLevel  = Integer.valueOf(req.getParameter("accessLevel"));
        try {
            if(userService.registration(login, password, name, lastName, email,accessLevel)){
                logger.trace("true");
                resp.sendRedirect("/reviews/login");
            }else{
                logger.trace("false");
                req.getRequestDispatcher("/error.jsp").forward(req, resp);
            }
        } catch (UserDaoException e) {
            logger.error(e);
        }
    }
}
