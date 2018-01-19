package ua.lviv.lgs.service;

import ua.lviv.lgs.entity.Account;
import ua.lviv.lgs.entity.Friends;

import java.util.List;

/**
 * Created by Apple on 02.04.2017.
 */
public interface FriendService {
    void add(Friends friends);

    void edit(int id, Friends friends);

    void delete(int id);

    Friends findById(int id);

    List<Friends> findAll();

    List<Account> getAllMyFriends(String login);

    List<Friends> findAllFriendId(int id);
}
