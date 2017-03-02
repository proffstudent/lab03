package main.services;

import main.common.exceptions.UserDaoException;
import main.models.dao.UserDao;
import main.models.pojo.User;

import java.util.List;

/**
 * Created by smoldyrev on 24.02.17.
 */
public class UserService {

    public static List<User> getAllUsers(){
        return UserDao.getAllUsers();
    }

    public static int insertUser(User user) throws UserDaoException {
        return UserDao.insertUser(user);
    }

    public static int updateUserOnId(User user) throws UserDaoException {
        return UserDao.updateUser(user);
    }

    public static int deleteUserOnId(int id) {
        return UserDao.deleteUser(id);
    }
    public static User authorise(String login, String password) throws UserDaoException {
        return UserDao.getUserByLoginAndPassword(login, password);
    }

    public static boolean registration(String login, String password, String email, Integer accessLevel) throws UserDaoException {
        return UserDao.registrationUser(login, password,email,accessLevel);
    }

}
