package main.controllers;

import main.models.dao.UserDao;
import main.models.pojo.User;
import org.apache.log4j.Logger;
import main.services.UserService;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by smoldyrev on 24.02.17.
 */
public class UsersServlet extends HttpServlet {

    private UserDao userDao;
    public void setUserDao(UserDao userDao){this.userDao = userDao;}

    private static Logger logger = Logger.getLogger(UsersServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        AutowireCapableBeanFactory beanFactory = ac.getAutowireCapableBeanFactory();
        userDao = (UserDao) beanFactory.getBean("userDaoJdbc");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<User> users= userDao.getAllUsers();
        logger.debug(users.size());
        req.setAttribute("users", users);
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
