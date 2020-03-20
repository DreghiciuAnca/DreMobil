package com.example.dremobil.data;

public class User {
    private String userId;
    private String userNume;
    private String userPrenume;


    private String userEmail;
    private String userAdresa;
    private String userTelefon;
    private String userIban;

    public User()
    {

    }
    public User(String userId, String userNume, String userPrenume, String userEmail, String userAdresa, String userTelefon, String userIban) {
        this.userId = userId;
        this.userNume = userNume;
        this.userPrenume = userPrenume;
        this.userEmail = userEmail;
        this.userAdresa = userAdresa;
        this.userTelefon = userTelefon;
        this.userIban = userIban;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNume() {
        return userNume;
    }

    public void setUserNume(String userNume) {
        this.userNume = userNume;
    }

    public String getUserPrenume() {
        return userPrenume;
    }

    public void setUserPrenume(String userPrenume) {
        this.userPrenume = userPrenume;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAdresa() {
        return userAdresa;
    }

    public void setUserAdresa(String userAdresa) {
        this.userAdresa = userAdresa;
    }

    public String getUserTelefon() {
        return userTelefon;
    }

    public void setUserTelefon(String userTelefon) {
        this.userTelefon = userTelefon;
    }

    public String getUserIban() {
        return userIban;
    }

    public void setUserIban(String userIban) {
        this.userIban = userIban;
    }
}
