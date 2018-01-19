package ua.lviv.lgs.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Apple on 08.03.2017.
 */
@Entity
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private int idFriend;
    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;


    public Friends() {
    }

    public Friends(int idFriend, Account account) {
        this.idFriend = idFriend;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFriend() {
        return idFriend;
    }

    public void setIdFriend(int idFriend) {
        this.idFriend = idFriend;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}

