package ua.lviv.lgs.dao;

import com.restfb.types.User;
import ua.lviv.lgs.entity.Message;

import java.util.List;

/**
 * Created by Apple on 30.03.17.
 */
public interface MessageDao {

    void add(Message message);

    void edit(Message message);

    void delete(Message message);

    Message findById(int id);

    Message findByUserId(int id);

    Message findByLogin(String login);

    List<Message> showAll(int id, int idi);

    List<Message> showAllToMe(int id, int idi);

    List<Message> showAllMessageFromFriends(int myId);

    Message getLastMessageWithUser(int myId, int idUser);
}
