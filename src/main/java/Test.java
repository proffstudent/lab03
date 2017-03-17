import su.ogorodov.common.exceptions.UserDaoException;
import su.ogorodov.models.connector.PostgresJdbcConnector;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.HashMap;

/**
 * Created by User on 01.03.2017.
 */
public class Test {
    private static Logger logger = Logger.getLogger(Test.class);

    public static void main(String[] args) throws UserDaoException {


        logger.info("logger work!!!");
        Connection con = PostgresJdbcConnector.getConnection();
        /*try {
            UserDAO.registrationUser("loginww", "1","wwww");
        } catch (UserDAOException e) {
            e.printStackTrace();
        }*/

        /*try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM \"main\".\"user\"");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        //UserDaoJdbc.updateUser(new User(1,"2","2","2","2","2",new java.sql.Date(new java.util.Date().getTime()),new java.sql.Date(new java.util.Date().getTime()),true,"2", new java.sql.Date(new java.util.Date().getTime()),"2","2","2","2","2","2","2",1));


        logger.trace("try logger!");
        logger.error("help us");
    }
}
