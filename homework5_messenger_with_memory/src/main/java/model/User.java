package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User implements Serializable {
    private static final long serialVersionUID = -9068154429397087780L;
    private String login;
    private String password;
    private String name;
    private String birthDate;
    private LocalDateTime registrationDate;

    public User(String login, String password, String name, String birthDate, LocalDateTime registrationDate) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistrationDateAsString(){
        return registrationDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm-ss"));
    }
}
