package main.models.dao;

import main.common.exceptions.UserDaoException;
import main.models.pojo.User;

import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
public interface UserDao {
    List<User> getAllUsers();
    static User getUserById(int id) throws UserDaoException{
        return null;
    }
    static int updateUser(User user) throws UserDaoException{
        return 0;
    }
    static int insertUser(User user) throws UserDaoException{
        return 0;
    }
    static int deleteUser(int id){
        return 0;
    }
    static User  getUserByLoginAndPassword(String login, String password) throws UserDaoException{
        return null;
    }
    static boolean registrationUser(String login, String password, String email, Integer accessLevel)
            throws UserDaoException{
        return false;
    }
}
