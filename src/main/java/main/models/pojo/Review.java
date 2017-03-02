package main.models.pojo;

import java.util.Date;


public class Review  {
    private Integer id = null;
    private User user;
    private Article article;
    private String pathReview;
    private Date dateOfReceipt;
    private Date dateReview;



    public Integer getId() {
        return id;
    }


    public User getUser() {
        return user;
    }


    public Article getArticle() {
        return article;
    }


    public String getPathReview() {
        return pathReview;
    }


    public Date getDateOfReceipt() {
        return dateOfReceipt;
    }


    public Date getDateReview() {
        return dateReview;
    }

    public void setId(Integer idReview) {
        this.id = idReview;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setPathReview(String pathReview) {
        this.pathReview = pathReview;
    }

    public void setDateOfReceipt(Date dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public void setDateReview(Date dateReview) {
        this.dateReview = dateReview;
    }
}
