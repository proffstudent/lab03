package main.services;

import main.common.exceptions.UserDaoException;
import main.models.dao.UserDao;
import main.models.jdbc.UserDaoJdbc;
import main.models.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserDao userDao;
    private static Logger logger = Logger.getLogger(UserService.class);

   public List<User> getAllUsers(){
       try {
           return userDao.getAllUsers();
       } catch (UserDaoException e) {
           return null;
       }
   }

    public int deleteUserOnId(int id) {
        try {
            logger.info("deleteUserOnId " + id);
            return userDao.deleteUser(id);
        } catch (UserDaoException e) {
            return 0;
        }
    }
    public int insertUser(User user) throws UserDaoException {
        try {
            logger.info( "insertUser " + user.getId() + " " + user.getName());
            return userDao.insertUser(user);
        } catch (UserDaoException e) {
            return 0;
        }
    }

    public User getUserById(int id) throws UserDaoException {
        try {
            logger.info("getUserById " + id);
            return userDao.getUserById(id);
        } catch (UserDaoException e) {
            return null;
        }
    }

    public int updateUser(User user) throws UserDaoException {
        try {
            logger.info( "insertUser " + user.getId() + " " + user.getName());
            return userDao.updateUser(user);
        } catch (UserDaoException e) {
            return 0;
        }
    }


    public User authorise(String login, String password) throws UserDaoException {
        try {
            logger.info( "authorise " + login + " " + password);
            return userDao.getUserByLoginAndPassword(login, password);
        } catch (UserDaoException e) {
            return null;
        }
    }

    public static boolean registration(String login, String password, String email, Integer accessLevel) throws UserDaoException {
        return UserDaoJdbc.registrationUser(login, password,email,accessLevel);
    }

}
