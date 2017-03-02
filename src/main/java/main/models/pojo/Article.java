package main.models.pojo;

import java.util.Date;



public class Article {
    private Integer id = null;
    private String title;
    private String subject;
    private boolean dontPubl;
    private String pathArticle;
    private String pathAnnotRus;
    private String pathAnnotEng;
    private String pathListLiter;
    private Date dateSend;
    private Date dateAdoption;
    private Date datePubl;
    private String url;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public boolean isDontPubl() {
        return dontPubl;
    }

    public String getPathArticle() {
        return pathArticle;
    }

    public String getPathAnnotRus() {
        return pathAnnotRus;
    }

    public String getPathAnnotEng() {
        return pathAnnotEng;
    }

    public String getPathListLiter() {
        return pathListLiter;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public Date getDateAdoption() {
        return dateAdoption;
    }

    public Date getDatePubl() {
        return datePubl;
    }

    public String getUrl() {
        return url;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDontPubl(boolean dontPubl) {
        this.dontPubl = dontPubl;
    }

    public void setPathArticle(String pathArticle) {
        this.pathArticle = pathArticle;
    }

    public void setPathAnnotRus(String pathAnnotRus) {
        this.pathAnnotRus = pathAnnotRus;
    }

    public void setPathAnnotEng(String pathAnnotEng) {
        this.pathAnnotEng = pathAnnotEng;
    }

    public void setPathListLiter(String pathListLiter) {
        this.pathListLiter = pathListLiter;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    public void setDateAdoption(Date dateAdoption) {
        this.dateAdoption = dateAdoption;
    }

    public void setDatePubl(Date datePubl) {
        this.datePubl = datePubl;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
