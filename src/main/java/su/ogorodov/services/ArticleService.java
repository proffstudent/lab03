package su.ogorodov.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import su.ogorodov.common.exceptions.ArticleDaoException;
import su.ogorodov.models.dao.ArticleDao;
import su.ogorodov.models.pojo.Article;

import java.util.List;

/**
 * Created by User on 17.03.2017.
 */
@Component
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    private static Logger logger = Logger.getLogger(ArticleService.class);

    public List<Article> getPublArticles() {
        try {
            return articleDao.getPublArticles();
        } catch (ArticleDaoException e) {
            return null;
        }
    }
}