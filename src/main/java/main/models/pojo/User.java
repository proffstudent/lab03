package main.models.pojo;

import java.util.Date;

public class User{
    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private boolean enabled;
    private String sex;
    private Date birth;
    private String residence;
    private String education;
    private String workplace;
    private String position;
    private String passport;
    private String issuedBy;
    private String addressReg;
    private int accessLevel;

    public User() {
    }

    public User(Integer id, String name, String lastName, String email, String login,
                String password, Date createdAt, Date updatedAt, boolean enabled,
                String sex, Date birth, String residence, String education, String workplace,
                String position, String passport, String issuedBy, String addressReg, int accessLevel) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.enabled = enabled;
        this.sex = sex;
        this.birth = birth;
        this.residence = residence;
        this.education = education;
        this.workplace = workplace;
        this.position = position;
        this.passport = passport;
        this.issuedBy = issuedBy;
        this.addressReg = addressReg;
        this.accessLevel = accessLevel;
    }

    public User(int id, String login, String password, int accessLevel, String email) {
        this.id = id;
        this.name = null;
        this.lastName = null;
        this.email = email;
        this.login = login;
        this.password = password;
        this.createdAt = null;
        this.updatedAt = null;
        this.enabled = true;
        this.sex = null;
        this.birth = null;
        this.residence = null;
        this.education = null;
        this.workplace = null;
        this.position = null;
        this.passport = null;
        this.issuedBy = null;
        this.addressReg = null;
        this.accessLevel = accessLevel;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirth() {
        return birth;
    }

    public String getResidence() {
        return residence;
    }

    public String getEducation() {
        return education;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getPosition() {
        return position;
    }

    public String getPassport() {
        return passport;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public String getAddressReg() {
        return addressReg;
    }

    public int getLevel() {
        return accessLevel;
    }

    public void setId(Integer idUser) {
        this.id = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public void setAddressReg(String addressReg) {
        this.addressReg = addressReg;
    }

    public void setLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
