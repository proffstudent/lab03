package main.models.dao;

import main.common.exceptions.UserDaoException;
import main.models.connector.PostgresJdbcConnector;
import main.models.pojo.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static boolean auth = false;

    public static boolean getAuth(){
        return auth;
    }
    private static String SQL_ALL_USERS= "SELECT * FROM public.users";

    private static final String SQL_FIND_USER_LOGIN_PASS = "SELECT * FROM  public.users " +
            "WHERE login = ? AND password = ?";

    private static final String SQL_CREATE_USER = "INSERT INTO  public.users(login, password, email, accessLevel) VALUES (?,?,?,?)";

    private static String SQL_DELETE_USER = "DELETE FROM public.users WHERE id = ?";

    private static String SQL_UPDATE_USER = "UPDATE Users SET name = ?, lastName = ?, email = ?, login = ?, password = ?, createdAt = ?," +
            " updatedAt = ?, enabled = ?, sex = ?, birth = ?, residence = ?, education = ?, workplace = ?," +
            " position = ?, passport = ?, issuedBy = ?, adrressReg = ?, accessLevel = ? WHERE id = ?;";

    private static String SQL_INSERT_USER = "INSERT INTO public.users (name, lastName, email, login, password, createdAt, updatedAt," +
            "enabled, sex, birth, residence, education, workplace, position, passport, issuedBy," +
            "adrressReg, accessLevel) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    private static String SQL_FIND_USER = "SELECT * FROM public.users WHERE id =?";


    private static Logger logger = Logger.getLogger(UserDao.class);

    public static List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        try(Connection connection = PostgresJdbcConnector.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_ALL_USERS);

            while(rs.next()) {
                logger.debug(rs.getString("name"));
                User user = new User(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("lastName"),
                rs.getString("email"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getDate("createdAt"),
                rs.getDate("updatedAt"),
                rs.getBoolean("enabled"),
                rs.getString("sex"),
                rs.getDate("birth"),
                rs.getString("residence"),
                rs.getString("education"),
                rs.getString("workplace"),
                rs.getString("position"),
                rs.getString("passport"),
                rs.getString("issuedBy"),
                rs.getString("adrressReg"),
                rs.getInt("accessLevel"));
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        logger.debug(users.size());
        return users;
    }

    public static User getUserById(int id) throws UserDaoException {
        logger.debug(id);
        User user = null;
        try(Connection connection = PostgresJdbcConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER)){
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                auth = true;
                logger.debug("find users: " + id);
                user = new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getDate("createdAt"),
                        rs.getDate("updatedAt"),
                        rs.getBoolean("enabled"),
                        rs.getString("sex"),
                        rs.getDate("birth"),
                        rs.getString("residence"),
                        rs.getString("education"),
                        rs.getString("workplace"),
                        rs.getString("position"),
                        rs.getString("passport"),
                        rs.getString("issuedBy"),
                        rs.getString("adrressReg"),
                        rs.getInt("accessLevel"));
            }else {
                logger.debug("Not found user: " + id);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new UserDaoException();
        }
        return user;
    }

    public static int updateUser(User user) throws UserDaoException {
        int count = 0;
        try (Connection connection = PostgresJdbcConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER)){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, "test");
            preparedStatement.setString(5, "test");
            preparedStatement.setDate(6, new java.sql.Date(new java.util.Date().getTime()));
            preparedStatement.setDate(7, new java.sql.Date(new java.util.Date().getTime()));
            preparedStatement.setBoolean(8, true);
            preparedStatement.setString(9, "t");
            preparedStatement.setDate(10, new java.sql.Date(new java.util.Date().getTime()));
            preparedStatement.setString(11, "test");
            preparedStatement.setString(12, "test");
            preparedStatement.setString(13, "test");
            preparedStatement.setString(14, "test");
            preparedStatement.setString(15, "test");
            preparedStatement.setString(16, "test");
            preparedStatement.setString(17, "test");
            preparedStatement.setInt(18, user.getLevel());
            preparedStatement.setInt(19,user.getId());
            System.out.println(preparedStatement.toString());
            count = preparedStatement.executeUpdate();
            logger.debug(user.getId()+" user was update "+user.getName());
        } catch (SQLException e) {
            logger.error(e);
            throw new UserDaoException();
        }
        return count;
    }

    public static int insertUser(User user) throws UserDaoException {
        int count = 0;
        try (Connection connection = PostgresJdbcConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER)){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setDate(6, (Date) user.getCreatedAt());
            preparedStatement.setDate(7, (Date) user.getUpdatedAt());
            preparedStatement.setBoolean(8, user.isEnabled());
            preparedStatement.setString(9, user.getSex());
            preparedStatement.setDate(10, (Date) user.getBirth());
            preparedStatement.setString(11, user.getResidence());
            preparedStatement.setString(12, user.getEducation());
            preparedStatement.setString(13, user.getWorkplace());
            preparedStatement.setString(14, user.getPosition());
            preparedStatement.setString(15, user.getPassport());
            preparedStatement.setString(16, user.getIssuedBy());
            preparedStatement.setString(17, user.getAddressReg());
            preparedStatement.setInt(18, user.getLevel());
            count = preparedStatement.executeUpdate();
            logger.debug(user.getId()+" user was insert "+user.getName());
        } catch (SQLException e) {
            logger.error(e);
            throw new UserDaoException();
        }
        return count;
    }

    public static int deleteUser(int id) {
        int count = 0;
        try(Connection connection = PostgresJdbcConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER)) {
            preparedStatement.setInt(1, id);
            count = preparedStatement.executeUpdate();
            logger.debug(id+" user was deleted");
        } catch (SQLException e) {
            logger.error(e);
        }
        return count;
    }

    public static User  getUserByLoginAndPassword(String login, String password) throws UserDaoException {

        logger.debug(login + " " + password);
        User user = null;
        try(Connection connection = PostgresJdbcConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER_LOGIN_PASS)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                auth = true;
                logger.debug("find - getAuth -" + getAuth());
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getInt("accessLevel"),
                        resultSet.getString("email")
                );
            }else{
                auth = false;
                logger.debug(login + " " + password + " not found - getAuth - " + getAuth());
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new UserDaoException();
        }
        return user;
    }

    public static boolean registrationUser(String login, String password, String email, Integer accessLevel) throws UserDaoException {
        try(Connection connection = PostgresJdbcConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_USER)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, accessLevel);
            int count = preparedStatement.executeUpdate();
            if(count > 0){
                logger.debug("inserted " + count);
                return true;
            }else{
                logger.debug(login + " " + password + " not inserted");
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return false;
    }
}


