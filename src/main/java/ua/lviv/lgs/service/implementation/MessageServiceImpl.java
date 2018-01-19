package ua.lviv.lgs.service.implementation;

import com.restfb.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.AccountDao;
import ua.lviv.lgs.dao.MessageDao;
import ua.lviv.lgs.entity.Account;
import ua.lviv.lgs.entity.Friends;
import ua.lviv.lgs.entity.Message;
import ua.lviv.lgs.service.AccountService;
import ua.lviv.lgs.service.MessageService;

import java.util.*;

/**
 * Created by Apple on 30.03.17.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private AccountService accountDao;


    public void add(String text, Account account, Account account1) {
        messageDao.add(new Message(text, account, account1));
    }

    public Message findById(int id) {
        return messageDao.findById(id);
    }

    public Message findByUserId(int id) {
        return messageDao.findByUserId(id);
    }

    public Message findByLogin(String login) {
        return messageDao.findByLogin(login);
    }

    public List<Message> showAll(int id, int idi) {
        return messageDao.showAll(id, idi);
    }

    public List<Message> showAllToMe(int id, int idi) {
        return messageDao.showAllToMe(id, idi);
    }

    private List<Account> getAllAccountsWhoWriteMe(int myId) {
        Set<Account> accounts = new HashSet<>();
        for (Message message : messageDao.showAllMessageFromFriends(myId)) {
            if (myId != message.getMyId().getId()) {
                accounts.add(message.getMyId());
            } else if (myId != message.getUserId().getId()) {
                accounts.add(message.getUserId());
            }
        }
        return new ArrayList<>(accounts);
    }

    private List<Message> showAllMessageFromFriends(int myId) {
        List<Message> messages = new ArrayList<>();
        for (Account account : getAllAccountsWhoWriteMe(myId)) {
            messages.add(messageDao.getLastMessageWithUser(myId, account.getId()));
        }
        return messages;
    }

    @Override
    public List<Message> showAllSortedMessageFromFriends(int myId) {
        List<Message> messages = new ArrayList<>(showAllMessageFromFriends(myId));
        Collections.sort(messages);
        return messages;
    }
}
