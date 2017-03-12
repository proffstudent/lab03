package su.ogorodov.models.dao;

import su.ogorodov.common.exceptions.UserDaoException;
import su.ogorodov.models.pojo.User;

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

    boolean registrationUser(String login, String password, String name, String lastName, String email,
                                    Integer accessLevel)
            throws UserDaoException;
}
