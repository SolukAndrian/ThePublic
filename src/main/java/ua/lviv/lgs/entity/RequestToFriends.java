package ua.lviv.lgs.entity;

import javax.persistence.*;

/**
 * Created by Apple on 02.04.2017.
 */
@Entity
public class RequestToFriends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Account friendId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Account accountId;

    public RequestToFriends() {
    }

    public RequestToFriends(Account friendId, Account accountId) {
        this.friendId = friendId;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Account getIdFriend() {
        return friendId;
    }

    public void setIdFriend(Account friendId) {
        this.friendId = friendId;
    }
}

