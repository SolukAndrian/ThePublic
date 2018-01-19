package ua.lviv.lgs.dao;

import ua.lviv.lgs.entity.RequestToFriends;

import java.util.List;

/**
 * Created by Apple on 02.04.2017.
 */
public interface RequestToFriendsDao {

    void add(RequestToFriends requestToFriends);

    void edit(RequestToFriends requestToFriends);

    void remove(RequestToFriends requestToFriends);

    RequestToFriends findById(int id);

    List<RequestToFriends> findAll();
}
