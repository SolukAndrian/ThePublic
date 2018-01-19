package ua.lviv.lgs.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Apple on 08.03.2017.
 */
@Entity
public class Message implements Comparable<Message> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String text;

    @ManyToOne
    private Account myId;
    @ManyToOne
    private Account userId;

    private Date date;

    public Message() {
    }

    public Message(String text, Account myId, Account userId) {
        this.text = text;
        this.myId = myId;
        this.userId = userId;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Account getMyId() {
        return myId;
    }

    public void setMyId(Account myId) {
        this.myId = myId;
    }

    public Account getUserId() {
        return userId;
    }

    public void setUserId(Account userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", myId=" + myId +
                ", userId=" + userId +
                '}';
    }

    @Override
    public int compareTo(Message message) {
        return message.getDate().compareTo(getDate());
    }
}
