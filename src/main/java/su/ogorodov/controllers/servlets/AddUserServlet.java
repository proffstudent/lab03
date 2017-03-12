package su.ogorodov.controllers.servlets;

import su.ogorodov.common.exceptions.UserDaoException;
import su.ogorodov.models.pojo.User;
import org.apache.log4j.Logger;
import su.ogorodov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddUserServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(AddUserServlet.class);
    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String strId = req.getParameter("id");
        logger.trace("on doGet - - " + strId);
        int id = (strId.equals("")) ? 0 : Integer.parseInt(req.getParameter("id"));
        logger.trace("on doGet - - " + id);
        User user = new User();
        if (id != 0) {
            try {
                user = userService.getUserById(id);
            } catch (UserDaoException e) {
                logger.error(e);
            }
        }
        req.setAttribute("id",user.getId()==null ? 0 : user.getId());
        req.setAttribute("name", user.getName());
        req.setAttribute("lastName", user.getLastName());
        req.setAttribute("email", user.getEmail());
        req.setAttribute("accessLevel", user.getAccessLevel());
        logger.trace("test user id " +user.getId()+ "test req id "  + req.getAttribute("id"));
        req.getRequestDispatcher("/adduser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.trace("on edit");
        String strId = req.getParameter("id");
        logger.debug(req.getParameter("id"));
        int id = (strId.equals("")) ? 0 : Integer.parseInt(req.getParameter("id"));
        User user = new User();
        user.setId(id);
        user.setName(req.getParameter("name"));
        user.setLastName(req.getParameter("lastName"));
        logger.debug("/" + req.getParameter("name"));
        logger.debug("//" + user.getName());
        user.setEmail(req.getParameter("email"));
        user.setAccessLevel(Integer.parseInt(req.getParameter("accessLevel")));
        int count = 0;
        logger.debug(id);
        if (id == 0) {
            try {
                count = userService.insertUser(user);
            } catch (UserDaoException e) {
                logger.error(e);
            }
        } else {
            try {
                count = userService.updateUser(user);
            } catch (UserDaoException e) {
                logger.error(e);
            }
        }
        if (count != 0) {
            logger.trace("true");
            resp.sendRedirect("/reviews/users");
        } else {
            logger.trace("false");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}
