package main.models.dao;

import main.common.exceptions.UserDaoException;
import main.models.pojo.User;

import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
public interface UserDao {
    List<User> getAllUsers() throws UserDaoException;

    int deleteUser(int id)throws UserDaoException;

    User getUserById(int id) throws UserDaoException;

    int insertUser(User user) throws UserDaoException;

    int updateUser(User user) throws UserDaoException;

    User  getUserByLoginAndPassword(String login, String password) throws UserDaoException;

    static boolean registrationUser(String login, String password, String email, Integer accessLevel)
            throws UserDaoException{
        return false;
    }
}
