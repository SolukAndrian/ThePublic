package ua.lviv.lgs.service;

import ua.lviv.lgs.entity.Account;
import ua.lviv.lgs.entity.Friends;
import ua.lviv.lgs.entity.RequestToFriends;

import java.util.List;

/**
 * Created by Apple on 02.04.2017.
 */
public interface RequestToFriendsService {
    void add(RequestToFriends requestToFriends);

    RequestToFriends findById(int id);

    void delete(int id);

    List<RequestToFriends> findAll();

    List<Account> getAllMyRequest(String login);

    void acceptRequest(Integer id, String login);

    void rejectRequest(Integer id, String login);
}
