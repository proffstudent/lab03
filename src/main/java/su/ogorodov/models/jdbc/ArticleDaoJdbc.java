package su.ogorodov.models.jdbc;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import su.ogorodov.common.exceptions.ArticleDaoException;
import su.ogorodov.models.dao.ArticleDao;
import su.ogorodov.models.pojo.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 16.03.2017.
 */
@Component
public class ArticleDaoJdbc implements ArticleDao{

    private JdbcTemplate jdbcTemplate;

    private static String SQL_PUBL_ARTICLES = "SELECT id, title, subject FROM articles WHERE datepubl IS NOT NULL";

    private static Logger logger = Logger.getLogger(ArticleDaoJdbc.class);

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private static class ArticleRowMapper implements RowMapper<Article> {
        @Override
        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
            logger.debug("ArticleRowMapper");
            Article user = new Article(rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("subject"));
            return user;
        }
    }

    public List<Article> getPublArticles() throws ArticleDaoException {
        logger.debug("getAllUsers");
        List<Article> publications = this.jdbcTemplate.query(SQL_PUBL_ARTICLES, new ArticleRowMapper());
        logger.debug(publications.size());
        return publications;
    }
}
