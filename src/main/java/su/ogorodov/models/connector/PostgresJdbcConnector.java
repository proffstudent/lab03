package su.ogorodov.models.connector;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by smoldyrev on 23.02.17.
 */
public class PostgresJdbcConnector {

    private static Logger logger = Logger.getLogger(PostgresJdbcConnector.class);

    private static Connection connection;

    private static PostgresJdbcConnector ourInstance = new PostgresJdbcConnector();

    public static PostgresJdbcConnector getInstance() {
        return ourInstance;
    }

    private PostgresJdbcConnector() {
    }

    /**Возвращает подключение к БД
     * @return connection
     */
    public static Connection getConnection() {
        try {
            if (connection!=null) connection.close();
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/publications";
            connection = DriverManager.getConnection(url, "postgres", "hH1508985");
            logger.trace("Successful connect to base: "+url);
        } catch (ClassNotFoundException e) {
            logger.error(e);
            System.out.println("Не найден драйвер");
        } catch (SQLException e) {
            logger.error(e);
            System.out.println("Ошибка подключение к БД!");
        }
        return connection;
    }
}
