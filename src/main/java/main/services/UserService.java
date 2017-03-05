package main.services;

import main.common.exceptions.UserDaoException;
import main.models.jdbc.UserDaoJdbc;
import main.models.pojo.User;

import java.util.List;


public class UserService {

   /* public List<User> getAllUsers(){
        List<User> all = use
        return UserDaoJdbc.getAllUsers();
    }*/

    public static int insertUser(User user) throws UserDaoException {
        return UserDaoJdbc.insertUser(user);
    }

    public static int updateUserOnId(User user) throws UserDaoException {
        return UserDaoJdbc.updateUser(user);
    }

    public static int deleteUserOnId(int id) {
        return UserDaoJdbc.deleteUser(id);
    }
    public static User authorise(String login, String password) throws UserDaoException {
        return UserDaoJdbc.getUserByLoginAndPassword(login, password);
    }

    public static boolean registration(String login, String password, String email, Integer accessLevel) throws UserDaoException {
        return UserDaoJdbc.registrationUser(login, password,email,accessLevel);
    }

}
