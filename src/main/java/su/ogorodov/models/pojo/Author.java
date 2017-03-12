package su.ogorodov.models.pojo;

public class Author  {
    private Integer id = null;
    private User user;
    private Article article;

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Article getArticle() {
        return article;
    }

    public void setId(Integer idAuthor) {
        this.id = idAuthor;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
