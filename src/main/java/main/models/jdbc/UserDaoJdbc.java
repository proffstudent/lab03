package main.models.jdbc;

import main.common.exceptions.UserDaoException;
import main.models.connector.PostgresJdbcConnector;
import main.models.dao.UserDao;
import main.models.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoJdbc implements UserDao{

    private static boolean auth = false;
    private JdbcTemplate jdbcTemplate;

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


    private static Logger logger = Logger.getLogger(UserDaoJdbc.class);

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            logger.debug("UserRowMapper");
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
            return user;
        }
    }

    public List<User> getAllUsers() throws UserDaoException{
        logger.debug("getAllUsers");
        List<User> users = jdbcTemplate.query(SQL_ALL_USERS, new UserRowMapper());
        logger.debug(users.size());
        return users;
    }

    public int deleteUser(int id)throws UserDaoException {
        int count = 0;
        logger.info("count deleteUser " + count);
        count = jdbcTemplate.update(SQL_DELETE_USER, id);
        return count;
    }

    public User getUserById(int id) throws UserDaoException {
        logger.debug("getUserById " + id);
        User user = null;
        auth = true;
        user = jdbcTemplate.queryForObject(SQL_FIND_USER, new UserRowMapper(), id);
        return user;
    }

    public int insertUser(User user) throws UserDaoException {
        int count = 0;
        count = jdbcTemplate.update(SQL_INSERT_USER,  user.getName(),user.getLastName(),user.getEmail(),user.getLogin(),
             user.getPassword(),(Date) user.getCreatedAt(),(Date) user.getUpdatedAt(),user.isEnabled(), user.getSex(),
            (Date) user.getBirth(),user.getResidence(), user.getEducation(),user.getWorkplace(), user.getPosition(),
            user.getPassport(),user.getIssuedBy(), user.getAddressReg(), user.getLevel());
        logger.debug(user.getId()+" user was insert "+user.getName());
        return count;
    }

    public int updateUser(User user) throws UserDaoException {
        int count = 0;
        count = jdbcTemplate.update(SQL_UPDATE_USER,  user.getName(),user.getLastName(),user.getEmail(),user.getLogin(),
                user.getPassword(),(Date) user.getCreatedAt(),(Date) user.getUpdatedAt(),user.isEnabled(), user.getSex(),
                (Date) user.getBirth(),user.getResidence(), user.getEducation(),user.getWorkplace(), user.getPosition(),
                user.getPassport(),user.getIssuedBy(), user.getAddressReg(), user.getLevel(), user.getId());
        logger.debug(user.getId()+" user was insert "+user.getName());
        return count;
    }


    public User getUserByLoginAndPassword(String login, String password) throws UserDaoException {
        logger.debug("getUserByLoginAndPassword " +  login + " password "+ password);
        User user = null;
        user = jdbcTemplate.queryForObject(SQL_FIND_USER_LOGIN_PASS, new UserRowMapper(), login, password);
        if(user != null) {
            auth = true;
            logger.debug(login + " " + password + " found - getAuth - " + getAuth());
        } else {
            auth = false;
            logger.debug(login + " " + password + " not found - getAuth - " + getAuth());
        }
        return user;
    }

    /*public static User getUserByLoginAndPassword(String login, String password) throws UserDaoException {

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
    }*/

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


