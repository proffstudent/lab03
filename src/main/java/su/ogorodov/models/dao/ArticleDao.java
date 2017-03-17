package su.ogorodov.models.dao;

import su.ogorodov.common.exceptions.ArticleDaoException;
import su.ogorodov.models.pojo.Article;

import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
public interface ArticleDao {
    List<Article> getPublArticles() throws ArticleDaoException;


}
