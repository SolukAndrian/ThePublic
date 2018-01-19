package ua.lviv.lgs.dao;

import ua.lviv.lgs.entity.Friends;

import java.util.List;

/**
 * Created by Apple on 02.04.2017.
 */
public interface FriendDao {

    void add(Friends friends);

    void edit(Friends friends);

    void delete(Friends friends);

    Friends findById(int id);

    List<Friends> findAll();

    List<Friends> findAllFriendId(int id);
}
