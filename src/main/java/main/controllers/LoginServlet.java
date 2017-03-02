package main.controllers;

import main.common.exceptions.UserDaoException;
import main.models.pojo.User;
import main.services.UserService;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/students/login.jsp").forward(req,resp);
          req.getRequestDispatcher("/login.jsp").forward(req,resp);
          logger.trace("loginGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            User user =UserService.authorise(login,password);
            logger.error(user);

            if (user!=null && user.getId()!=0) {
                req.getSession().setAttribute("id",user.getId());
                logger.trace("auth");
                resp.sendRedirect("/reviews/users");
            } else {
                logger.trace("noauth");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        } catch (UserDaoException e) {
            logger.error(e);
            resp.sendRedirect("/reviews/error.jsp");
        }
    }
}
