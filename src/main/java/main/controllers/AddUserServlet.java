package main.controllers;

import main.common.exceptions.UserDaoException;
import main.models.dao.UserDao;
import main.models.pojo.User;
import org.apache.log4j.Logger;
import main.services.UserService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddUserServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(AddUserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String strId = req.getParameter("id");
        logger.trace("on doGet - - " + strId);
        int id = (strId.equals("")) ? 0 : Integer.parseInt(req.getParameter("id"));
        logger.trace("on doGet - - " + id);
        User user = new User();
        if (id != 0) {
            try {
                user = UserDao.getUserById(id);
            } catch (UserDaoException e) {
                logger.error(e);
            }
        }
        req.setAttribute("id", user.getId());
        req.setAttribute("name", user.getName());
        req.setAttribute("lastName", user.getLastName());
        req.setAttribute("email", user.getEmail());
        req.setAttribute("accessLevel", user.getLevel());
        logger.trace(user.getId());
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
        user.setLevel(Integer.parseInt(req.getParameter("accessLevel")));
        int count = 0;
        logger.debug(id);
        if (id == 0) {
            try {
                count = UserService.insertUser(user);
            } catch (UserDaoException e) {
                logger.error(e);
            }
        } else {
            try {
                count = UserService.updateUserOnId(user);
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
