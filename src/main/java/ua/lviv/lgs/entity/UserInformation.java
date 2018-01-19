package ua.lviv.lgs.entity;

import javax.persistence.*;

/**
 * Created by Apple on 24.03.17.
 */
@Entity
public class UserInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column()
    private String sex;
    @Column()
    private String maritalStatus;
    @Column()
    private int age;
    @Column()
    private String country;
    @Column()
    private String city;
    @Column()
    private String language;
    @Lob()
    private byte[] image;

    @OneToOne(fetch = FetchType.LAZY)
    private Account account;


    public UserInformation() {
    }

    public UserInformation(String sex, String maritalStatus, int age, String country, String city, String language, byte[] image, Account account) {
        this.sex = sex;
        this.maritalStatus = maritalStatus;
        this.age = age;
        this.country = country;
        this.city = city;
        this.language = language;
        this.image = image;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
