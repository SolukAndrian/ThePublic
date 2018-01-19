package ua.lviv.lgs.dto;

import java.util.Date;

/**
 * Created by Apple on 06.04.2017.
 */
public class RegistrationDto {
    private String surname;
    private String name;
    private Date date;
    private String email;
    private String phone;
    private String login;
    private String password;

    public RegistrationDto() {
    }

    public RegistrationDto(String surname, String name, Date date, String email, String phone, String login, String password) {
        this.surname = surname;
        this.name = name;
        this.date = date;
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
