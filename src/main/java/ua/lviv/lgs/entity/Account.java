package ua.lviv.lgs.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by Apple on 08.03.2017.
 */
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String name;
    @Column
    private Date date;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;

    private String secKey;

    @OneToMany(mappedBy = "account")
    private List<Friends> friendsList;

    @OneToMany(mappedBy = "myId")
    private List<Message> myList;

    public Account() {
    }

    @OneToMany(mappedBy = "userId")
    private List<Message> userList;

    public Account(int id) {
    }

    public Account(String surname, String name, Date date, String email, String phone, String login, String password) {
        this.date = date;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.secKey = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Friends> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<Friends> friendsList) {
        this.friendsList = friendsList;
    }

    public List<Message> getMyList() {
        return myList;
    }

    public void setMyList(List<Message> myList) {
        this.myList = myList;
    }

    public List<Message> getUserList() {
        return userList;
    }

    public void setUserList(List<Message> userList) {
        this.userList = userList;
    }

    public String getSecKey() {
        return secKey;
    }

    public void setSecKey(String secKey) {
        this.secKey = secKey;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getKey() {
        return secKey;
    }

    public void setKey(String key) {
        this.secKey = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
