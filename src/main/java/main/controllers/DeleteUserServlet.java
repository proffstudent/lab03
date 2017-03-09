package main.controllers;

import main.models.jdbc.UserDaoJdbc;
import org.apache.log4j.Logger;
import main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {

    @Autowired
    private UserService userService;



    private static Logger logger = Logger.getLogger(DeleteUserServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        logger.debug("del user id = " + req.getParameter("id") + " id = "+ id);
        logger.debug("Integer.parseInt(id) " + userService.toString());
        if (userService.deleteUserOnId(Integer.parseInt(id)) > 0) {
            logger.trace(req.getParameter("id") + " was deleted");
            resp.sendRedirect("/reviews/users");
        } else {
            logger.trace(id + " not deleted");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
