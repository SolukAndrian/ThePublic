package ua.lviv.lgs.service;

import ua.lviv.lgs.entity.Account;
import ua.lviv.lgs.entity.Friends;
import ua.lviv.lgs.entity.Message;

import java.util.List;

/**
 * Created by Apple on 30.03.17.
 */
public interface MessageService {

    void add(String text, Account account, Account account1);

    Message findById(int id);

    Message findByUserId(int id);

    Message findByLogin(String login);

    List<Message> showAll(int id, int idi);

    List<Message> showAllToMe(int id, int idi);

    List<Message> showAllSortedMessageFromFriends(int myId);

}
